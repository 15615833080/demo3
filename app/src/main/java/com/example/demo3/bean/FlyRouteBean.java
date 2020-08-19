package com.example.demo3.bean;

import java.util.List;

public class FlyRouteBean {
    /**
     * Id : string
     * DeviceId : string
     * Name : string
     * SumDistance : 0
     * RouteNo : string
     * SumPoints : 0
     * SetupTime : 2016-06-10T13:11:00.766Z
     * UsedTime : 0
     * Points : [{"Id":"string","RouteNo":"string","Name":"string","Longitude":"string","Latitude":"string","Height":0,"Distance":0,"Yaw":0,"Pitch":0,"Speed":0,"Usedtime":0}]
     */

    private String Id;
    private String DeviceId;
    private String Name;
    private int SumDistance;
    private String RouteNo;
    private int SumPoints;
    private String SetupTime;
    private int UsedTime;
    private List<PointsBean> Points;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String DeviceId) {
        this.DeviceId = DeviceId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getSumDistance() {
        return SumDistance;
    }

    public void setSumDistance(int SumDistance) {
        this.SumDistance = SumDistance;
    }

    public String getRouteNo() {
        return RouteNo;
    }

    public void setRouteNo(String RouteNo) {
        this.RouteNo = RouteNo;
    }

    public int getSumPoints() {
        return SumPoints;
    }

    public void setSumPoints(int SumPoints) {
        this.SumPoints = SumPoints;
    }

    public String getSetupTime() {
        return SetupTime;
    }

    public void setSetupTime(String SetupTime) {
        this.SetupTime = SetupTime;
    }

    public int getUsedTime() {
        return UsedTime;
    }

    public void setUsedTime(int UsedTime) {
        this.UsedTime = UsedTime;
    }

    public List<PointsBean> getPoints() {
        return Points;
    }

    public void setPoints(List<PointsBean> Points) {
        this.Points = Points;
    }

    public static class PointsBean {
        /**
         * Id : string
         * RouteNo : string
         * Name : string
         * Longitude : string
         * Latitude : string
         * Height : 0
         * Distance : 0
         * Yaw : 0
         * Pitch : 0
         * Speed : 0
         * Usedtime : 0
         */

        private String Id;
        private String RouteNo;
        private String Name;
        private String Longitude;
        private String Latitude;
        private int Height;
        private int Distance;
        private int Yaw;
        private int Pitch;
        private int Speed;
        private int Usedtime;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getRouteNo() {
            return RouteNo;
        }

        public void setRouteNo(String RouteNo) {
            this.RouteNo = RouteNo;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getLongitude() {
            return Longitude;
        }

        public void setLongitude(String Longitude) {
            this.Longitude = Longitude;
        }

        public String getLatitude() {
            return Latitude;
        }

        public void setLatitude(String Latitude) {
            this.Latitude = Latitude;
        }

        public int getHeight() {
            return Height;
        }

        public void setHeight(int Height) {
            this.Height = Height;
        }

        public int getDistance() {
            return Distance;
        }

        public void setDistance(int Distance) {
            this.Distance = Distance;
        }

        public int getYaw() {
            return Yaw;
        }

        public void setYaw(int Yaw) {
            this.Yaw = Yaw;
        }

        public int getPitch() {
            return Pitch;
        }

        public void setPitch(int Pitch) {
            this.Pitch = Pitch;
        }

        public int getSpeed() {
            return Speed;
        }

        public void setSpeed(int Speed) {
            this.Speed = Speed;
        }

        public int getUsedtime() {
            return Usedtime;
        }

        public void setUsedtime(int Usedtime) {
            this.Usedtime = Usedtime;
        }
    }
}
