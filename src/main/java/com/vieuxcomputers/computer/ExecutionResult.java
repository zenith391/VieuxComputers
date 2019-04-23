package com.vieuxcomputers.computer;

import java.util.Objects;

public class ExecutionResult {

	private ExecutionReturn ret;
	private Object arg1;
	
	public ExecutionResult(ExecutionReturn ret) {
		this(ret, null);
	}
	
	public ExecutionResult(ExecutionReturn ret, Object arg1) {
		Objects.requireNonNull(ret, "ExecutionReturn ret");
		this.ret = ret;
		this.arg1 = arg1;
	}
	
	public Object getArg1() {
		return arg1;
	}
	
	public ExecutionReturn getReturn() {
		return ret;
	}
	
}
