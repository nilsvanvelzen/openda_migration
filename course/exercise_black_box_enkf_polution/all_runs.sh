#! /bin/sh
#
# This script runs the standard tests
#
# It is assumed that SIMONA is set before running this script!

#
# Kalman filtering  
#

oda_run.sh SequentialSimulation.oda
oda_run.sh SequentialEnsembleSimulation.oda
oda_run.sh EnKF.oda
oda_run.sh EnKF2.oda

#ipython --matplotlib=gtk plot_movie.py
#ipython --matplotlib=gtk all_runs.py
