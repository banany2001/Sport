package by.bsu.fpmi.siachko.lab1.reading;

import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;
import by.bsu.fpmi.siachko.lab1.sportevent.events.game.Game;
import by.bsu.fpmi.siachko.lab1.sportevent.events.match.Match;
import by.bsu.fpmi.siachko.lab1.sportevent.events.race.Race;
import by.bsu.fpmi.siachko.lab1.sportevent.participant.GameParticipant;
import by.bsu.fpmi.siachko.lab1.sportevent.participant.MatchParticipant;
import by.bsu.fpmi.siachko.lab1.sportevent.participant.RaceParticipant;
import by.bsu.fpmi.siachko.lab1.sportevent.participant.Result;
import by.bsu.fpmi.siachko.lab1.sportevent.property.attendance.Attendance;
import by.bsu.fpmi.siachko.lab1.sportevent.property.date.Date;
import by.bsu.fpmi.siachko.lab1.sportevent.property.place.Place;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvDao<T extends SportEvent> extends AbstractDao<T> {

    private Scanner scanner;
    private Scanner lineScanner;
    private PrintWriter printWriter;

    private CsvDao(String fileName) {
        super(fileName);
    }

    public static <T> Dao<T> create(String fileName, Class<?> aClass)
    {
        return (Dao<T>) Proxy.newProxyInstance(
                aClass.getClassLoader(),
                new Class[]{Dao.class},
                new LoggingProxyHandler<>(new CsvDao(fileName))
        );
    }

    private Date readDate()
    {
        String dayOfWeek = lineScanner.next();
        int day = Integer.parseInt(lineScanner.next());
        int month = Integer.parseInt(lineScanner.next());
        int year = Integer.parseInt(lineScanner.next());
        return new Date(dayOfWeek, day, month, year);
    }

    private void writeDate(Date date)
    {
        printWriter.print(date.getDayOfWeek());
        printWriter.print(";");
        printWriter.print(date.getDay());
        printWriter.print(";");
        printWriter.print(date.getMonth());
        printWriter.print(";");
        printWriter.print(date.getYear());
        printWriter.print(";");
    }

    private Place readPlace()
    {
        String country = lineScanner.next();
        String region = lineScanner.next();
        String locality = lineScanner.next();
        String zipCode = lineScanner.next();
        String address = lineScanner.next();
        return new Place(country, region, locality, zipCode, address);
    }

    private void writePlace(Place place)
    {
        printWriter.print(place.getCountry());
        printWriter.print(";");
        printWriter.print(place.getRegion());
        printWriter.print(";");
        printWriter.print(place.getLocality());
        printWriter.print(";");
        printWriter.print(place.getZipCode());
        printWriter.print(";");
        printWriter.print(place.getAddress());
        printWriter.print(";");
    }

    private Attendance readAttendance()
    {
        int peopleUntil18 = Integer.parseInt(lineScanner.next());
        int peopleUntil30 = Integer.parseInt(lineScanner.next());
        int peopleUntil45 = Integer.parseInt(lineScanner.next());
        int peopleUntil60 = Integer.parseInt(lineScanner.next());
        int peopleAfter60 = Integer.parseInt(lineScanner.next());
        return new Attendance(peopleUntil18, peopleUntil30, peopleUntil45, peopleUntil60, peopleAfter60);
    }

    private void writeAttendance(Attendance attendance)
    {
        printWriter.print(attendance.getPeopleUntil18());
        printWriter.print(";");
        printWriter.print(attendance.getPeopleUntil30());
        printWriter.print(";");
        printWriter.print(attendance.getPeopleUntil45());
        printWriter.print(";");
        printWriter.print(attendance.getPeopleUntil60());
        printWriter.print(";");
        printWriter.print(attendance.getPeopleAfter60());
        printWriter.print(";");
    }

    private RaceParticipant readRaceParticipant() throws Exception
    {
        String name = lineScanner.next();
        String result = lineScanner.next();
        return new RaceParticipant(name, new Result(result));
    }

    private void writeRaceParticipant(RaceParticipant participant)
    {
        printWriter.print(participant.getName());
        printWriter.print(";");
        printWriter.print(participant.getResult());
        printWriter.print(";");
    }

    private MatchParticipant readMatchParticipant()
    {
        String name = lineScanner.next();
        boolean result = Boolean.parseBoolean(lineScanner.next());
        return new MatchParticipant(name, result);
    }

    private void writeMatchParticipant(MatchParticipant participant)
    {
        printWriter.print(participant.getName());
        printWriter.print(";");
        printWriter.print(participant.getResult());
        printWriter.print(";");
    }

    private GameParticipant readGameParticipant()
    {
        String name = lineScanner.next();
        int result = Integer.parseInt(lineScanner.next());
        return new GameParticipant(name, result);
    }

    private void writeGameParticipant(GameParticipant participant)
    {
        printWriter.print(participant.getName());
        printWriter.print(";");
        printWriter.print(participant.getPoints());
        printWriter.print(";");
    }

    private SportEvent readEvent() throws Exception
    {

        String type = lineScanner.next();
        Date date = readDate();
        Place place = readPlace();
        Attendance attendance = readAttendance();
        String name = lineScanner.next();

        if (type.equals("Race")){
            int n;
            n = Integer.parseInt(lineScanner.next());
            ArrayList<RaceParticipant> raceParticipants = new ArrayList<>();
            while (n != 0){
                raceParticipants.add(readRaceParticipant());
                n--;
            }
            return new Race(date, place, attendance, name, raceParticipants);
        }
        else if (type.equals("Match")){
            MatchParticipant participant1, participant2;
            participant1 = readMatchParticipant();
            participant2 = readMatchParticipant();
            return new Match(date, place, attendance, name, participant1, participant2);
        }
        else if (type.equals("Game")){
            GameParticipant participant1, participant2;
            participant1 = readGameParticipant();
            participant2 = readGameParticipant();
            return new Game(date, place, attendance, name, participant1, participant2);
        }
        return null;

    }

    private void writeEvent(SportEvent event)
    {

        if (event.getClass().equals(Race.class)){
            printWriter.print("Race;");
        }
        else if (event.getClass().equals(Match.class)){
            printWriter.print("Match;");
        }
        else if (event.getClass().equals(Game.class)){
            printWriter.print("Game;");
        }
        writeDate(event.getDate());
        writePlace(event.getPlace());
        writeAttendance(event.getAttendance());

        if (event.getClass().equals(Race.class)){
            Race race = (Race) event;
            printWriter.print(race.getRaceName() + ";");
            ArrayList<RaceParticipant> raceParticipants = race.getRaceParticipants();
            printWriter.print(raceParticipants.size());
            printWriter.print(";");
            for (RaceParticipant participant : raceParticipants){
                writeRaceParticipant(participant);
            }
        }
        else if (event.getClass().equals(Match.class)){
            Match match = (Match) event;
            printWriter.print(match.getMatchName() + ";");
            writeMatchParticipant(match.getMatchParticipant1());
            writeMatchParticipant(match.getMatchParticipant2());
        }
        else if (event.getClass().equals(Game.class)){
            Game game = (Game) event;
            printWriter.print(game.getGameName() + ";");
            writeGameParticipant(game.getGameParticipant1());
            writeGameParticipant(game.getGameParticipant2());
        }

    }

    @Override
    public List<T> read() throws IOException, Exception
    {
        List<T> list = new ArrayList<>();
        scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()){
            lineScanner = new Scanner(scanner.nextLine()).useDelimiter(";");
            list.add((T)readEvent());
        }
        return list;
    }

    @Override
    public void write(List<T> list) throws IOException
    {
        printWriter = new PrintWriter(new File(fileName));
        for (SportEvent sportEvent : list)
        {
            writeEvent(sportEvent);
            printWriter.println();
        }
        printWriter.close();
    }

}
