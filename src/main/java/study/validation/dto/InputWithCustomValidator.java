package study.validation.dto;

import study.validation.validator.IpAddress;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class InputWithCustomValidator {

    @Min(1)
    @Max(10)
    private int numberBetweenOneAndTen;

    @IpAddress(message = "IP Address가 올바르지 않습니다.")
    private String ipAddress;

    public int getNumberBetweenOneAndTen() {
        return numberBetweenOneAndTen;
    }

    public void setNumberBetweenOneAndTen(int numberBetweenOneAndTen) {
        this.numberBetweenOneAndTen = numberBetweenOneAndTen;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
