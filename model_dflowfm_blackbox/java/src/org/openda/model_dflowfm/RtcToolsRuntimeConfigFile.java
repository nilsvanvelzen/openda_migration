package org.openda.model_dflowfm;

import org.openda.interfaces.IDataObject;
import org.openda.interfaces.IExchangeItem;
import org.openda.interfaces.IPrevExchangeItem;
import org.openda.utils.ConfigTree;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * IDataObject for configuration file for d_hydro.exe.
 * Data object is used to modify start/end time
 */
public class RtcToolsRuntimeConfigFile implements IDataObject {

	static final String PROPERTY_STARTTIME = "StartTime";
	static final String PROPERTY_STOPTIME = "StopTime";

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

	private static final String CONFIG_TREE_ELEMENT_STARTDATE  = "period/userDefined/startDate@date";
	private static final String CONFIG_TREE_ELEMENT_STARTTIME  = "period/userDefined/startDate@time";
	private static final String CONFIG_TREE_ELEMENT_ENDDATE  = "period/userDefined/endDate@date";
	private static final String CONFIG_TREE_ELEMENT_ENDTIME  = "period/userDefined/endDate@time";

	String usageString = "RtcToolsRuntimeConfigFile DataObject must be initialised with 1 or 2 arguments: " +
			"InputFilePath [OutputFilePath]";

	private File workingDirectory;
	private String outputFileName = null;
	ConfigTree configTree = null;

	protected HashMap<String, IExchangeItem> exchangeItems;

	public void initialize(File workingDirectory, String[] arguments)
	{
		if(arguments.length != 1 && arguments.length != 2 ) {
			throw new RuntimeException(usageString);
		}
		String inputFileName = arguments[0];
		this.outputFileName = inputFileName;
		if (arguments.length > 1) {
			this.outputFileName = arguments[1];
		}

		this.workingDirectory = workingDirectory;
		configTree = new ConfigTree(workingDirectory, inputFileName);
		String startDateString = configTree.getAsString(CONFIG_TREE_ELEMENT_STARTDATE, "");
		String startTimeString = configTree.getAsString(CONFIG_TREE_ELEMENT_STARTTIME, "");
		String endDateString = configTree.getAsString(CONFIG_TREE_ELEMENT_ENDDATE, "");
		String endTimeString = configTree.getAsString(CONFIG_TREE_ELEMENT_ENDTIME, "");

		String startString = startDateString + " " + startTimeString;
		String endString = endDateString + " " + endTimeString;
		double mjdStartTime;
		double mjdEndTime;
		try {
			mjdStartTime = MjdUtils.parseMjdFromTimeString(startString);
			mjdEndTime = MjdUtils.parseMjdFromTimeString(endString);
		} catch (ParseException e) {
			throw new RuntimeException("Could not parse start/end date time in file " + new File(workingDirectory, inputFileName));
		}
		exchangeItems = new HashMap<>();
		exchangeItems.put(PROPERTY_STARTTIME, new Flow1DTimeInfoExchangeItem(Flow1DTimeInfoExchangeItem.PropertyId.StartTime, mjdStartTime));
		exchangeItems.put(PROPERTY_STOPTIME, new Flow1DTimeInfoExchangeItem(Flow1DTimeInfoExchangeItem.PropertyId.StopTime, mjdEndTime));
	}

	public String[] getExchangeItemIDs()
	{
		return exchangeItems.keySet().toArray(new String[exchangeItems.keySet().size()]);
	}

	public String[] getExchangeItemIDs(IPrevExchangeItem.Role role)
	{
		List<String> matchingExchangeItemIds = new ArrayList<>();
		for(IExchangeItem exchangeItem : exchangeItems.values())
			if(exchangeItem.getRole() == role) matchingExchangeItemIds.add(exchangeItem.getId());

		return matchingExchangeItemIds.toArray(new String[matchingExchangeItemIds.size()]);
	}

	public IExchangeItem getDataObjectExchangeItem(String exchangeItemID) { return exchangeItems.get(exchangeItemID); }

	public void finish()
	{
		IExchangeItem startTimeExchangeItem = exchangeItems.get(PROPERTY_STARTTIME);
		if(startTimeExchangeItem == null) throw new RuntimeException(String.format("Exchange item %s does not exist", PROPERTY_STARTTIME));
		double mjdStartTime = startTimeExchangeItem.getValuesAsDoubles()[0];
		Calendar startTime = MjdUtils.ConvertModifiedJulianDayToDateTime(mjdStartTime);
		configTree.setContentString(CONFIG_TREE_ELEMENT_STARTDATE, DATE_FORMAT.format(startTime.getTime()));
		configTree.setContentString(CONFIG_TREE_ELEMENT_STARTTIME, TIME_FORMAT.format(startTime.getTime()));

		IExchangeItem stopTimeExchangeItem = exchangeItems.get(PROPERTY_STOPTIME);
		if(stopTimeExchangeItem == null) throw new RuntimeException(String.format("Exchange item %s does not exist", PROPERTY_STOPTIME));
		double mjdEndTime = stopTimeExchangeItem.getValuesAsDoubles()[0];
		Calendar endTime = MjdUtils.ConvertModifiedJulianDayToDateTime(mjdEndTime);
		configTree.setContentString(CONFIG_TREE_ELEMENT_ENDDATE, DATE_FORMAT.format(endTime.getTime()));
		configTree.setContentString(CONFIG_TREE_ELEMENT_ENDTIME, TIME_FORMAT.format(endTime.getTime()));

		configTree.toFile(workingDirectory, outputFileName);
	}
}
