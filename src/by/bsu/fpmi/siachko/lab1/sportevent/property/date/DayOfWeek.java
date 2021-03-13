package by.bsu.fpmi.siachko.lab1.sportevent.property.date;

public enum DayOfWeek {

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public String toString() {
        if (this == MONDAY){
            return "Monday";
        }
        else if (this == TUESDAY){
            return "Tuesday";
        }
        else if (this == WEDNESDAY){
            return "Wednesday";
        }
        else if (this == THURSDAY){
            return "Thursday";
        }
        else if (this == FRIDAY){
            return "Friday";
        }
        else if (this == SATURDAY){
            return "Saturday";
        }
        else if (this == SUNDAY){
            return "Sunday";
        }
        else {
            return "---";
        }
    }

    public static DayOfWeek convertFromString(String day) throws Exception
    {
        DayOfWeek dayOfWeek;
        if (day.toLowerCase().equals("monday")){
            dayOfWeek = MONDAY;
        }
        else if (day.toLowerCase().equals("tuesday")){
            dayOfWeek = TUESDAY;
        }
        else if (day.toLowerCase().equals("wednesday")){
            dayOfWeek = WEDNESDAY;
        }
        else if (day.toLowerCase().equals("thursday")){
            dayOfWeek = THURSDAY;
        }
        else if (day.toLowerCase().equals("friday")){
            dayOfWeek = FRIDAY;
        }
        else if (day.toLowerCase().equals("saturday")){
            dayOfWeek = SATURDAY;
        }
        else if (day.toLowerCase().equals("sunday")){
            dayOfWeek = SUNDAY;
        }
        else {
            throw new Exception();
        }
        return dayOfWeek;
    }
}
