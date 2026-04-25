class TimeMap {
    
    class TimeValue {
        int timestamp;
        String value;

        public TimeValue(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }

        public TimeValue(){

        }
    }
    HashMap<String, ArrayList<TimeValue>> map = new HashMap();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        TimeValue tv = new TimeValue(value, timestamp);
        ArrayList<TimeValue> list = (map.getOrDefault(key, new ArrayList<TimeValue>()));
        list.add(tv);
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        ArrayList<TimeValue> list = map.get(key);
        if(list == null || list.isEmpty() || list.get(0).timestamp > timestamp) return "";
        int len = list.size();
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid).timestamp > timestamp){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return list.get(right).value;
    }
}
