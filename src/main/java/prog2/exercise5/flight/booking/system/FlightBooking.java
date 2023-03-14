package prog2.exercise5.flight.booking.system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class FlightBooking {
    private final String flightCompany = " Flights-of-Fancy";
    private final String flightID = "19191810";
    public String getFlightID() {
        return flightID;
    }

    int num;
    private int childPassengers;
    private int adultPassengers = (num-1);
    private int totalPassengers;


    String[] NAME = {"Reimu Hakurei","Marisa Kirisame","Rumia","Cirno","Sikieiki Yamaxanadu","Koishi Komeiji"};
    String[] GENDER ={"Male","Female","Male","Female","Male","Female"};
    int[] AGE = {4,25,17,76,38,9};


    String[] passengerFullName = new String[3];
    String[] passengerGender = new String[3];
    int[] passengerAge = new int[3];                              //建立数组
    String[] ticketNumber = new String[3];


    public FlightBooking(int num) {
        this.num = num;
        setDepartureDate(departuredate);
        setReturnDate(returndate);                                          //构造器
        setTotalPassengers(childPassengers,adultPassengers);
        setDepartingTicketPrice(1,num-1);
        setReturnTicketPrice();
        setTotalTicketPrice();
    }
    public  void  reserveTickets(){
        int q = 0 ; int w = 0 ; int e = 0 ; int r = 0;
        for(q = 0; q < this.num ; ++q ){
            setPassengerFullName(q,NAME[q]);
        }

        for(w=0; w<this.num ; ++w){
            setPassengerGender(w ,GENDER[w]);}

        for(e=0; e<this.num ; ++e){
            setPassengerAge(e ,AGE[e]);}
                                                                        //循环着行
        for(r=0; r<this.num ; ++r){
            setBookingClass("1");
            setTripType("1");
            setTripSource("1");
            setTripDestination("2","1");
            setSourceAirport();
            setDestinationAirport();
            settype();
            setclasses();
            setabroad();
            setTicketNumber(this.num);
        }
        for(int o = 0; o < this.num ; ++o ) {
            System.out.println("\n" + "Here are the trip details for Passenger No." +(o+1) );
            System.out.println("Passenger's Ticket Number:" +  ticketNumber[o]);
            System.out.println("Passenger's Full Name:" +  passengerFullName[o]);
            System.out.println("Passenger's Age: " + passengerAge[o]);
            System.out.println("Passenger's Gender: " + passengerGender[o]);
            System.out.println("From:" + getTripSource() + "(" +getSource_airport() +")");
            System.out.println("To:" + getTripDestination() + "(" +getDestination_airport() +")");
            System.out.println("The flight departs on: " + getDepartureDate());
            System.out.println("And the return flight is on:" + getReturnDate());
        }
    }
    public void setPassengerFullName(int q,String Name) {
            this.NAME[q] = Name;
            this.passengerFullName[q] = Name;
    }
    public String getPassengerFullName(int num){
        this.num  = num;
        return passengerFullName[num];
    }

    public void setPassengerGender(int w, String Gender) {
        this.GENDER[w] = Gender;
        this.passengerGender[w] = Gender;
    }
    public String getPassengerGender(int num) {
        this.num = num;
        return passengerGender[num];
    }

    public void setPassengerAge(int e, int Age) {
        this.AGE[e] = Age;
        this.passengerAge[e] = Age;
    }
    public int getPassengerAge(int num){
        this.num = num;
        return passengerAge[num];
    }





    String Bookingclass;                                                    //囧仙坐头等舱吗
    FlightBooking.BookingClass bookingclass;
    public void setBookingClass(String BookingClass){

        switch (BookingClass)
        {
            case "1":
                bookingclass = FlightBooking.BookingClass.FIRST;
                break;
            case "2":
                bookingclass = FlightBooking.BookingClass.BUSINESS;
                break;
            case "3":
                bookingclass = FlightBooking.BookingClass.ECONOMY;
                break;
            default:
                System.out.println("wrong");
        }
        Bookingclass = String.valueOf(bookingclass);
    }
    public String getBooking(){return Bookingclass;}
    String Tripype;                                                                    //往返模式
    public void setTripType(String tripType){

        switch (tripType)
        {
            case "1":
                this.Tripype = "One way";
                break;
            case "2":
                this.Tripype= "Return";
                break;
            default:
                System.out.println("wrong");
        }
    }
    public String gettripType(){
        return Tripype;
    }

    String DepartureDate= "2023-03-04";
    LocalDate departuredate = LocalDate.parse(DepartureDate);
    String ReturnDate = "2023-03-05";
    LocalDate returndate = LocalDate.parse(ReturnDate);                                     //快去吧，我的爱人
    long Cha = ChronoUnit.DAYS.between(departuredate,returndate);                       //回来吧，我的爱人

    public void print(){
        System.out.println("IMPORTANT NOTICE: As per our policy, the return date was changed because it was \n" +
                "less than two days apart from your departure date.");
    }
    public void setDepartureDate(LocalDate departure) {
        if(Cha == 0){
            returndate = departuredate.plus(2, ChronoUnit.DAYS);
            //print();
        }
        else{departuredate = departuredate;}
    }
    public LocalDate getDepartureDate() {
        return departuredate;
    }

    public void setReturnDate(LocalDate returnDate) {                                       //   poikhftfcfccfctt
        if(Cha < 2){
            returndate = departuredate.plus(2, ChronoUnit.DAYS);
           // print();
        }
        else{departuredate = departuredate;}
    }

    public LocalDate getReturnDate() {
        return returndate;
    }



    public enum TripType{
        ONE_WAY, RETURN
    }
    public enum BookingClass{
        FIRST,BUSINESS,ECONOMY
    }
    public enum TripSource{
        NANJING, BEIJING, SHANGHAI,  OULU, HELSINKI,PARIS
    }
    public enum TripDestination{
        NANJING, BEIJING, SHANGHAI,  OULU, HELSINKI,PARIS
    }
    public enum SourceAirport{
        NANJING_LUKOU_INTERNATIONAL_AIRPORT, BEIJING_CAPITAL_INTERNATIONAL_AIRPORT, SHANGHAI_PUDONG_INTERNATIONAL_AIRPORT, OULU_AIRPORT, HELSINKI_AIRPORT, PARIS_CHARLES_DE_GAULLE_AIRPORT
    }
    public enum DestinationAirport{
        NANJING_LUKOU_INTERNATIONAL_AIRPORT, BEIJING_CAPITAL_INTERNATIONAL_AIRPORT, SHANGHAI_PUDONG_INTERNATIONAL_AIRPORT, OULU_AIRPORT, HELSINKI_AIRPORT, PARIS_CHARLES_DE_GAULLE_AIRPORT
    }
    String Tripsource;                                                                      //出发地
    FlightBooking.TripSource source;
    public void setTripSource(String tripsource){

        switch(tripsource){
            case "1":
                source = TripSource.NANJING;
                break;
            case "2":
                source = TripSource.BEIJING;
                break;
            case "3":
                source = TripSource.OULU;
                break;
            case "4":
                source = TripSource.HELSINKI;
                break;
            default:
                System.out.println("wrong");
        }
        Tripsource = String.valueOf(source);
    }
    public String getTripSource() {return Tripsource;
    }

    String TripSource_Airport;                                                             //出发场
    FlightBooking.SourceAirport source_airport;
    public void setSourceAirport(){
        if(Tripsource == "NANJING"){
            source_airport = SourceAirport.NANJING_LUKOU_INTERNATIONAL_AIRPORT;
        }
        if(Tripsource == "BEIJIN"){
            source_airport = SourceAirport.BEIJING_CAPITAL_INTERNATIONAL_AIRPORT;
        }
        if(Tripsource== " Oulu"){
            source_airport = SourceAirport.OULU_AIRPORT;
        }
        if(Tripsource == "HELSINKI"){
            source_airport = SourceAirport.HELSINKI_AIRPORT;
        }
        TripSource_Airport = String.valueOf(source_airport);
    }
    public String getSource_airport() {return TripSource_Airport;
    }



    String Tripdestination;
    FlightBooking.TripDestination destination;                                           //目的地

    public void setTripDestination(String tripdestination,String tripsource){
        switch(tripdestination){
            case "1":
                destination = TripDestination.NANJING;
                if(tripsource == "1"){destination = null;}
                break;
            case "2":
                destination = TripDestination.BEIJING;
                if(tripsource == "2"){destination = null;}
                break;
            case "3":
                destination = TripDestination.OULU;
                if(tripsource == "3"){destination = null;}
                break;
            case "4":
                destination = TripDestination.HELSINKI;
                if(tripsource == "4"){destination = null;}
                break;
            default:
                System.out.println("wrong");
        }
        Tripdestination = String.valueOf(destination);
    }
    public String getTripDestination() {return Tripdestination;
    }
    String TripDestination_Airport;                                                     //目的场
    FlightBooking.DestinationAirport destination_airport;
    public void setDestinationAirport(){
        if(Tripdestination == "NANJING"){
            destination_airport = DestinationAirport.NANJING_LUKOU_INTERNATIONAL_AIRPORT;
        }
        if(Tripdestination == "BEIJING"){
            destination_airport = DestinationAirport.BEIJING_CAPITAL_INTERNATIONAL_AIRPORT;
        }
        if(Tripdestination == "OULU"){
            destination_airport = DestinationAirport.OULU_AIRPORT;
        }
        if(Tripdestination == "HELSINKI"){
            destination_airport = DestinationAirport.HELSINKI_AIRPORT;
        }
        TripDestination_Airport = String.valueOf(destination_airport);

    }
    public String getDestination_airport() {return TripDestination_Airport;
    }


    String type;
    String classes;
    String abroad;
    public void settype() {
        if(Tripype == "One way"){
            type = "11";
        }
        if(Tripype == "Return"){
            type = "22";
        }
    }
    public void setclasses() {
        if(Bookingclass == "FIRST"){
            classes = "F";
        }
        if(Bookingclass == "BUSINESS"){
            classes = "B";
        }
        if(Bookingclass == "ECONOMY"){
            classes = "E";
        }
    }                                   //查成分
    public void setabroad() {
        if(Tripsource == "OULU" && Tripdestination == "HELSINKI"){
            abroad = "DOM";
        }
        if(Tripsource == "HELSINKI" && Tripdestination == "OULU"){
            abroad = "DOM";
        }
        if(Tripsource == "NANJING" && Tripdestination == "BEIJING"){
            abroad = "DOM";
        }
        if(Tripsource == "BEIJING" && Tripdestination == "NANJING"){                            // //查国际成分
            abroad = "DOM";
        }
        if(Tripsource == "NANJING" && Tripdestination == "OULU"){
            abroad = " INT";
        }
        if(Tripsource == "NANJING" && Tripdestination == "HELSINKI"){
            abroad = " INT";
        }
        if(Tripsource == "BEIJING" && Tripdestination == "OULU"){
            abroad = " INT";
        }
        if(Tripsource == "BEIJING" && Tripdestination == "HELSINKI"){
            abroad = " INT";
        }
        if (Tripsource == "OULU" && Tripdestination == "NANJING"){
            abroad = " INT";
        }
        if (Tripsource == "OULU" && Tripdestination == "BEIJING"){
            abroad = " INT";
        }
        if (Tripsource == "HELSINKI" && Tripdestination == "NANJING"){
            abroad = " INT";
        }
        if (Tripsource== "HELSINKI" && Tripdestination == "BEIJING"){
            abroad = " INT";
        }

    }


    public void setTicketNumber(int num){
        this.num = num;
        for(int t = 0; t < num; ++t)
            ticketNumber[t] = type + classes + "1919" +abroad;
                                                                            //合成大怨种
    }
    public String[] getTicketNumber() {
        return ticketNumber;
    }



    public int getChildrenPassengers() {return childPassengers;
    }

    public int getAdultPassengers() {return adultPassengers;
    }

    public String getFlightCompany() {return flightCompany;
    }

    public void setTotalPassengers(int childPassengers, int adultPassengers) {
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
        this.totalPassengers =adultPassengers+childPassengers;
    }

    public int getTotalPassengers() {
        return totalPassengers;
    }

    double TotalTicketPrice;
    double DepartingTicketPrice;
    double ReturnTicketPrice;
    public void setDepartingTicketPrice(int child,int adult) {
        if(type == "11") {
            if (Bookingclass == "FIRST") {
                DepartingTicketPrice = (child + adult) * (300 + 300 * 0.1 + 300 * 0.05);
                DepartingTicketPrice = 250 + DepartingTicketPrice;
            }
            if (Bookingclass == "BUSINESS") {
                DepartingTicketPrice = (child + adult) * (300 + 300 * 0.1 + 300 * 0.05);
                DepartingTicketPrice = 150 + DepartingTicketPrice;
            }
            if (Bookingclass == "ECONOMY") {
                DepartingTicketPrice = (child + adult) * (300 + 300 * 0.1 + 300 * 0.05);
                DepartingTicketPrice = 50 + DepartingTicketPrice;
            }
            if (type == "22") {
                if (Bookingclass == "FIRST") {
                    DepartingTicketPrice = (child + adult) * (300 + 300 * 0.15 + 300 * 0.1);
                    DepartingTicketPrice = 250 + DepartingTicketPrice;
                }
                if (Bookingclass == "BUSINESS") {
                    DepartingTicketPrice = (child + adult) * (300 + 300 * 0.15 + 300 * 0.1);
                    DepartingTicketPrice = 150 + DepartingTicketPrice;
                }
                if (Bookingclass == "ECONOMY") {
                    DepartingTicketPrice = (child + adult) * (300 + 300 * 0.15 + 300 * 0.1);
                }
                DepartingTicketPrice = 50 + DepartingTicketPrice;
            }
        }
    }
    public void setReturnTicketPrice() {
        ReturnTicketPrice = this.DepartingTicketPrice;
    }
    public void  setTotalTicketPrice(){
        TotalTicketPrice = this.DepartingTicketPrice + this.ReturnTicketPrice;
    }
    public double getTotalTicketPrice() {
        return TotalTicketPrice;
    }
    public String toString(){
        return  "Thank you for booking your flight with " + flightCompany+ "\n"+
                "You reserved a total of "+ num  + " tickets."+"\n" +
                "The total ticket price is: " + getTotalTicketPrice();

    }
}

