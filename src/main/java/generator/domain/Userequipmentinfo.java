package generator.domain;

import java.io.Serializable;

/**
 * 
 * @TableName userequipmentinfo
 */
public class Userequipmentinfo implements Serializable {
    /**
     * 用户ID
     */
    private Integer userid;

    /**
     * 骑行台ID
     */
    private Integer bikerinfoid;

    /**
     * 功率计ID
     */
    private Integer pminfoid;

    /**
     * 速度传感器ID
     */
    private Integer speedsinfoid;

    /**
     * 心率计设备ID
     */
    private Integer hrmeinfoid;

    /**
     * 踏频设备ID
     */
    private Integer fseinfoid;

    /**
     * 摄像头ID
     */
    private Integer camerainfoid;

    /**
     * fitting台ID
     */
    private Integer fittinginfoid;

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 用户ID
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 骑行台ID
     */
    public Integer getBikerinfoid() {
        return bikerinfoid;
    }

    /**
     * 骑行台ID
     */
    public void setBikerinfoid(Integer bikerinfoid) {
        this.bikerinfoid = bikerinfoid;
    }

    /**
     * 功率计ID
     */
    public Integer getPminfoid() {
        return pminfoid;
    }

    /**
     * 功率计ID
     */
    public void setPminfoid(Integer pminfoid) {
        this.pminfoid = pminfoid;
    }

    /**
     * 速度传感器ID
     */
    public Integer getSpeedsinfoid() {
        return speedsinfoid;
    }

    /**
     * 速度传感器ID
     */
    public void setSpeedsinfoid(Integer speedsinfoid) {
        this.speedsinfoid = speedsinfoid;
    }

    /**
     * 心率计设备ID
     */
    public Integer getHrmeinfoid() {
        return hrmeinfoid;
    }

    /**
     * 心率计设备ID
     */
    public void setHrmeinfoid(Integer hrmeinfoid) {
        this.hrmeinfoid = hrmeinfoid;
    }

    /**
     * 踏频设备ID
     */
    public Integer getFseinfoid() {
        return fseinfoid;
    }

    /**
     * 踏频设备ID
     */
    public void setFseinfoid(Integer fseinfoid) {
        this.fseinfoid = fseinfoid;
    }

    /**
     * 摄像头ID
     */
    public Integer getCamerainfoid() {
        return camerainfoid;
    }

    /**
     * 摄像头ID
     */
    public void setCamerainfoid(Integer camerainfoid) {
        this.camerainfoid = camerainfoid;
    }

    /**
     * fitting台ID
     */
    public Integer getFittinginfoid() {
        return fittinginfoid;
    }

    /**
     * fitting台ID
     */
    public void setFittinginfoid(Integer fittinginfoid) {
        this.fittinginfoid = fittinginfoid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Userequipmentinfo other = (Userequipmentinfo) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getBikerinfoid() == null ? other.getBikerinfoid() == null : this.getBikerinfoid().equals(other.getBikerinfoid()))
            && (this.getPminfoid() == null ? other.getPminfoid() == null : this.getPminfoid().equals(other.getPminfoid()))
            && (this.getSpeedsinfoid() == null ? other.getSpeedsinfoid() == null : this.getSpeedsinfoid().equals(other.getSpeedsinfoid()))
            && (this.getHrmeinfoid() == null ? other.getHrmeinfoid() == null : this.getHrmeinfoid().equals(other.getHrmeinfoid()))
            && (this.getFseinfoid() == null ? other.getFseinfoid() == null : this.getFseinfoid().equals(other.getFseinfoid()))
            && (this.getCamerainfoid() == null ? other.getCamerainfoid() == null : this.getCamerainfoid().equals(other.getCamerainfoid()))
            && (this.getFittinginfoid() == null ? other.getFittinginfoid() == null : this.getFittinginfoid().equals(other.getFittinginfoid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getBikerinfoid() == null) ? 0 : getBikerinfoid().hashCode());
        result = prime * result + ((getPminfoid() == null) ? 0 : getPminfoid().hashCode());
        result = prime * result + ((getSpeedsinfoid() == null) ? 0 : getSpeedsinfoid().hashCode());
        result = prime * result + ((getHrmeinfoid() == null) ? 0 : getHrmeinfoid().hashCode());
        result = prime * result + ((getFseinfoid() == null) ? 0 : getFseinfoid().hashCode());
        result = prime * result + ((getCamerainfoid() == null) ? 0 : getCamerainfoid().hashCode());
        result = prime * result + ((getFittinginfoid() == null) ? 0 : getFittinginfoid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", bikerinfoid=").append(bikerinfoid);
        sb.append(", pminfoid=").append(pminfoid);
        sb.append(", speedsinfoid=").append(speedsinfoid);
        sb.append(", hrmeinfoid=").append(hrmeinfoid);
        sb.append(", fseinfoid=").append(fseinfoid);
        sb.append(", camerainfoid=").append(camerainfoid);
        sb.append(", fittinginfoid=").append(fittinginfoid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}