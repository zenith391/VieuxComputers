package com.vieuxcomputers.computer;

public enum ExecutionReturn {

	YIELD, // re-execute at next tick, could also be named READY
	WAIT_EVENT, // give event at next tick
	SHUTDOWN, // set computer state to shutdown
	RESTART; // set computer state to restarting
	
}
