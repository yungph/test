package com.crudoperations.response;

public class ServiceResult {
    private boolean status;
    private String message;//in case status is false this will contains error message
    private Object output;//in case of success and need to return json as output

    public ServiceResult(){
    	
    }
    
    public ServiceResult(boolean status, String message, Object output){
    	setStatus(status);
    	setMessage(message);
    	setOutput(output);
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
	 * @return the output
	 */
	public Object getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(Object output) {
		this.output = output;
	}

	public static ServiceResult generateResult(boolean status, String message, Object output) {
    	return new ServiceResult(status, message, output);
    }
	
	public static ServiceResult generateErrorResult(String errMessage) {
    	return generateResult(false, errMessage, null);
    }
	
	public static ServiceResult generateSuccessResult() {
    	return generateResult(true, null, null);
    }
	
	
	public static ServiceResult generateSuccessResult(Object output) {
    	return new ServiceResult(true, null, output);
    }

	public static ServiceResult generateSuccessResult(String message, Object output) {
    	return generateResult(true, message, output);
    }
}

