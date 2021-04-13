#!/bin/bash
while [[ ! -e ./stopIBM ]] ; do
	while [[ ! -e ./ibm || ! -e ./stopIBM ]] ; do
		sleep 1
	done
	if [[ ! -e ./stopIBM ]]
	then
		rm ibm && firefox https://welcome.oda.sas.com/login
	fi
done
rm stopIBM
