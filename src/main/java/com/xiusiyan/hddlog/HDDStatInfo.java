package com.xiusiyan.hddlog;
import java.util.Scanner;


/**
 * HDDStatInfo
 *
 * @author RaymondXiu
 * @version 1.0, 2011-6-18
 * @see
 */
public class HDDStatInfo {
    int controllerIndex;
    int portIndex;
    String status;
    String model;
    String firmwareVersion;
    String serial;
    String capacity;
    String wwn;
    String driveType;
    String interfaceType;
    String drivePorts;
    String driveConnections;
    String reallocatedSectors;
    String powerOnHours;
    int temperature;
    String spindleSpeed;
    String linkSpeedSupported;
    String linkSpeed;
    String queuingSupported;
    String queuingEnabled;
    String identifyStatus;
    String belongsToUnit;
    
    public HDDStatInfo(int i, String buf){
        this.portIndex = i;
        int offset = i < 10 ? 7 : 8;
        Scanner scan = new Scanner(buf);
        
        try{
            while(scan.hasNextLine()){
                String input = scan.nextLine();
                
                if(input.startsWith("Status", offset)){
                    this.status = input.substring(16).trim();
                }else if(input.startsWith("Model", offset)){
                    this.model = input.substring(15).trim();
                }else if(input.startsWith("Firmware Version", 7)){
                    this.firmwareVersion = input.substring(26).trim();
                }else if(input.startsWith("Serial", offset)){
                    this.serial = input.substring(16).trim();
                }else if(input.startsWith("Capacity", offset)){
                    this.capacity = input.substring(18).trim();
                }else if(input.startsWith("WWN", offset)){
                    this.wwn = input.substring(13).trim();
                }else if(input.startsWith("Drive Type", offset)){
                    this.driveType = input.substring(20).trim();
                }else if(input.startsWith("Interface Type", offset)){
                    this.interfaceType = input.substring(24).trim();
                }else if(input.startsWith("Drive Ports", offset)){
                    this.drivePorts = input.substring(21).trim();
                }else if(input.startsWith("Drive Connections", offset)){
                    this.driveConnections = input.substring(27).trim();
                }else if(input.startsWith("Reallocated Sectors", offset)){
                    this.reallocatedSectors = input.substring(29).trim();
                }else if(input.startsWith("Power On Hours", offset)){
                    this.powerOnHours = input.substring(24).trim();
                }else if(input.startsWith("Temperature", offset)){
                    try{
                    this.temperature = Integer.parseInt(input.substring(21).trim().substring(0,2));
                    }catch(Exception e){
                        this.temperature = 0;
                    }
                }else if(input.startsWith("Spindle Speed", offset)){
                    this.spindleSpeed = input.substring(23).trim();
                }else if(input.startsWith("Link Speed Supported", offset)){
                    this.linkSpeedSupported = input.substring(30).trim();
                }else if(input.startsWith("Link Speed", offset)){
                    this.linkSpeed = input.substring(20).trim();
                }else if(input.startsWith("Queuing Supported", offset)){
                    this.queuingSupported = input.substring(27).trim();
                }else if(input.startsWith("Queuing Enabled", offset)){
                    this.queuingEnabled = input.substring(25).trim();
                }else if(input.startsWith("Identify Status", offset)){
                    this.identifyStatus = input.substring(25).trim();
                }else if(input.startsWith("Belongs to Unit", offset)){
                    this.belongsToUnit = input.substring(25).trim();
                }    
            }
        }finally{
            scan.close();
        }
        
    }
    
    /**
     * @return the index
     */
    public int getIndex() {
        return this.portIndex;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return this.model;
    }

    /**
     * @return the firmwareVersion
     */
    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    /**
     * @return the serial
     */
    public String getSerial() {
        return this.serial;
    }

    /**
     * @return the capacity
     */
    public String getCapacity() {
        return this.capacity;
    }

    /**
     * @return the wwn
     */
    public String getWwn() {
        return this.wwn;
    }

    /**
     * @return the driveType
     */
    public String getDriveType() {
        return this.driveType;
    }

    /**
     * @return the interfaceType
     */
    public String getInterfaceType() {
        return this.interfaceType;
    }

    /**
     * @return the drivePorts
     */
    public String getDrivePorts() {
        return this.drivePorts;
    }

    /**
     * @return the driveConnections
     */
    public String getDriveConnections() {
        return this.driveConnections;
    }

    /**
     * @return the reallocatedSectors
     */
    public String getReallocatedSectors() {
        return this.reallocatedSectors;
    }

    /**
     * @return the powerOnHours
     */
    public String getPowerOnHours() {
        return this.powerOnHours;
    }

    /**
     * @return the temperature
     */
    public int getTemperature() {
        return this.temperature;
    }

    /**
     * @return the spindleSpeed
     */
    public String getSpindleSpeed() {
        return this.spindleSpeed;
    }

    /**
     * @return the linkSpeedSupported
     */
    public String getLinkSpeedSupported() {
        return this.linkSpeedSupported;
    }

    /**
     * @return the linkSpeed
     */
    public String getLinkSpeed() {
        return this.linkSpeed;
    }

    /**
     * @return the queuingSupported
     */
    public String getQueuingSupported() {
        return this.queuingSupported;
    }

    /**
     * @return the queuingEnabled
     */
    public String getQueuingEnabled() {
        return this.queuingEnabled;
    }

    /**
     * @return the identifyStatus
     */
    public String getIdentifyStatus() {
        return this.identifyStatus;
    }

    /**
     * @return the belongsToUnit
     */
    public String getBelongsToUnit() {
        return this.belongsToUnit;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HDDStatInfo [controllerIndex=" + this.controllerIndex + ", portIndex=" + this.portIndex + ", status="
                + this.status + ", model=" + this.model + ", firmwareVersion=" + this.firmwareVersion + ", serial="
                + this.serial + ", capacity=" + this.capacity + ", wwn=" + this.wwn + ", driveType=" + this.driveType
                + ", interfaceType=" + this.interfaceType + ", drivePorts=" + this.drivePorts + ", driveConnections="
                + this.driveConnections + ", reallocatedSectors=" + this.reallocatedSectors + ", powerOnHours="
                + this.powerOnHours + ", temperature=" + this.temperature + ", spindleSpeed=" + this.spindleSpeed
                + ", linkSpeedSupported=" + this.linkSpeedSupported + ", linkSpeed=" + this.linkSpeed
                + ", queuingSupported=" + this.queuingSupported + ", queuingEnabled=" + this.queuingEnabled
                + ", identifyStatus=" + this.identifyStatus + ", belongsToUnit=" + this.belongsToUnit + "]";
    }

}
