package com.vieuxcomputers.computer;

public enum MachineState {

	RUNNING,
	READY, // ready to go to RUNNING state
	SHUTTING_DOWN,
	OFF,
	SLEEPING,
	WAITING_EVENT;
	
}
