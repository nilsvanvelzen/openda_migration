#! /usr/bin/python
# -*- coding: utf-8 -*-
"""
Created on Fri Jul  3 16:38:17 2015

@author: verlaanm
"""

import numpy as np
import matplotlib.pyplot as plt

import simulation_truth_results as truth
import simulation_initial_results as initial
import simulation_enkf_results as enkf
import simulation_enkf_results_seed31415 as enkf2

plt.subplot(2,1,1)
plt.plot(initial.model_time,initial.x[:,0],'g')
plt.plot(truth.model_time,truth.x[:,0],'k')
plt.plot(enkf.analysis_time,enkf.x_f_central[::2,0],'b');
plt.plot(enkf2.analysis_time,enkf2.x_f_central[::2,0],'r');
plt.legend(('initial','truth','EnKF seed=21','EnKF seed=31415'))
plt.ylabel(r'$\theta_1$')
plt.subplot(2,1,2)
plt.plot(initial.model_time,initial.x[:,1],'g')
plt.plot(truth.model_time,truth.x[:,1],'k')
plt.plot(enkf.analysis_time,enkf.x_f_central[::2,1],'b');
plt.plot(enkf2.analysis_time,enkf2.x_f_central[::2,1],'r');
plt.ylabel(r'$\theta_2$')
plt.xlabel(r'$t$')
#plt.savefig('plot2.png')
plt.show() 

