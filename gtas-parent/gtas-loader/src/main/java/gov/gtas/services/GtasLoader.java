package gov.gtas.services;

import gov.gtas.model.*;
import gov.gtas.parsers.exception.ParseException;
import gov.gtas.parsers.vo.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GtasLoader {
    void checkHashCode(String hash) throws LoaderException;
    void processReportingParties(ApisMessage apisMessage, List<ReportingPartyVo> parties);
    void processPnr(Pnr pnr, PnrVo vo) throws ParseException;
    Flight processFlightsAndBookingDetails(List<FlightVo> flights,
                                           Set<Flight> messageFlights,
                                           List<FlightLeg> flightLegs,
                                           String[] primeFlightKey,
                                           Set<BookingDetail> bookingDetails) throws ParseException;
    CreatedAndOldPassengerInformation makeNewPassengerObjects(Flight primeFlight,
                                           List<PassengerVo> passengers,
                                           Set<Passenger> messagePassengers,
                                           Set<BookingDetail> bookingDetails,
                                           Message message) throws ParseException;
    void createBagsFromPnrVo(PnrVo pvo,Pnr pnr);
    void createFormPfPayments(PnrVo vo,Pnr pnr);
    void updatePassenger(Passenger existingPassenger, PassengerVo pvo) throws ParseException;
    int createPassengers(Set<Passenger> newPassengers, Set<Passenger> messagePassengers, Flight primeFlight, Set<BookingDetail> bookingDetails);
    void updateFlightPassengerCount(Flight primeFlight, int createdPassengers);
    void createBookingDetails(Pnr pnr, Map<Long, Set<BookingDetail>> passBookDetails);
}
