/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author DINH KHANG
 */
public class CustomGenericException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errCode;
	private String errMsg;

	//getter and setter methods

	public CustomGenericException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
