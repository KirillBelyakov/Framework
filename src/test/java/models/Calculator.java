package models;

import java.util.Objects;

public class Calculator {

    private String numberOfInstances;
    private String operatingSystem;
    private String machineClass;
    private String machineSeries;
    private String machineType;
    private String numberOfGpu;
    private String gpuType;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public Calculator(String numberOfInstances, String operatingSystem,
                      String machineClass, String machineSeries, String machineType, String numberOfGpu,
                      String gpuType, String localSSD, String datacenterLocation,
                      String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.machineSeries = machineSeries;
        this.machineType = machineType;
        this.numberOfGpu = numberOfGpu;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getMachineSeries() {
        return machineSeries;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getNumberOfGpu() {
        return numberOfGpu;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", machineSeries='" + machineSeries + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfGpu='" + numberOfGpu + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calculator)) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) &&
                Objects.equals(operatingSystem, that.operatingSystem) &&
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(machineSeries, that.machineSeries) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(numberOfGpu, that.numberOfGpu) &&
                Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(localSSD, that.localSSD) &&
                Objects.equals(datacenterLocation, that.datacenterLocation) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        int result = numberOfInstances != null ? numberOfInstances.hashCode() : 0;
        result = 31 * result + (operatingSystem != null ? operatingSystem.hashCode() : 0);
        result = 31 * result + (machineClass != null ? machineClass.hashCode() : 0);
        result = 31 * result + (machineSeries != null ? machineSeries.hashCode() : 0);
        result = 31 * result + (machineType != null ? machineType.hashCode() : 0);
        result = 31 * result + (numberOfGpu != null ? numberOfGpu.hashCode() : 0);
        result = 31 * result + (gpuType != null ? gpuType.hashCode() : 0);
        result = 31 * result + (localSSD != null ? localSSD.hashCode() : 0);
        result = 31 * result + (datacenterLocation != null ? datacenterLocation.hashCode() : 0);
        result = 31 * result + (committedUsage != null ? committedUsage.hashCode() : 0);
        return result;
    }
}
