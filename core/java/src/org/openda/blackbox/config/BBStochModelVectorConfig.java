/* OpenDA v2.4.3 
* Copyright (c) 2017 OpenDA Association 
* All rights reserved.
* 
* This file is part of OpenDA. 
* 
* OpenDA is free software: you can redistribute it and/or modify 
* it under the terms of the GNU Lesser General Public License as 
* published by the Free Software Foundation, either version 3 of 
* the License, or (at your option) any later version. 
* 
* OpenDA is distributed in the hope that it will be useful, 
* but WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
* GNU Lesser General Public License for more details. 
* 
* You should have received a copy of the GNU Lesser General Public License
* along with OpenDA.  If not, see <http://www.gnu.org/licenses/>.
*/


package org.openda.blackbox.config;

import org.openda.interfaces.IDimensionIndex;

/**
 * Configuration informationg for a Black Box Stoch Model Vector or Subvector
 */
public class BBStochModelVectorConfig {

    private String id;
    private String sourceId;
    private IDimensionIndex[] selectionIndices;
    private BBConfigurable selectorConfig;

    public BBStochModelVectorConfig(String id, String sourceId, IDimensionIndex[] selectionIndices, BBConfigurable selectorConfig) {
        this.id = id;
        this.sourceId = sourceId;
        this.selectionIndices = selectionIndices;
        this.selectorConfig = selectorConfig;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getId() {
        return id;
    }

    public IDimensionIndex[] getSelectionIndices() {
        return selectionIndices;
    }

    public BBConfigurable getSelectorConfig() {
        return selectorConfig;
    }
}
