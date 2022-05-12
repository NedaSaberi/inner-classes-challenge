package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        // Modify the playlist challenge so that the Album class uses an inner class.
        // Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
        // The inner SongList class will use an ArrayList and will provide a method to add a song.
        // It will also provide findSong() methods which will be used by the containing Album class
        // to add songs to the playlist.
        // Neither the Song class or the Main class should be changed.



        Album album = new Album("Love", "Fateme");
        Album.SongList songList = album.new SongList();
        songList.addSong("ti11", 2.75);
        songList.addSong("ti22", 34.5);
        songList.addSong("ti33", 3.98);
        songList.addSong("ti44", 43.09);
        songList.addSong("ti555", 12.21);
        songList.addSong("ti66", 12.098);
        songList.addSong("ti77", 3.9);
        songList.addSong("ti88", 3.0);

        albums.add(album);

        album = new Album("Lie", "Ali");
        Album.SongList songList1 = album.new SongList();
        songList1.addSong("li11", 2.0);
        songList1.addSong("li22", 2.9);
        songList1.addSong("li33", 4.54);
        songList1.addSong("li44", 23445.54);
        songList1.addSong("li55", 223.909);
        songList1.addSong("li66", 1.0);
        songList1.addSong("li77", 3.45);
        songList1.addSong("li88", 54.98);
        songList1.addSong("li99", 2.90);
        songList1.addSong("li10", 2.2);

        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();

        albums.get(0).addToPlayList("ti77", playList);
        albums.get(0).addToPlayList("ti22", playList);
        albums.get(0).addToPlayList("ti88", playList);
        albums.get(0).addToPlayList("ti12", playList);// invalid
        albums.get(0).addToPlayList("ti11", playList);
        albums.get(0).addToPlayList(100, playList);// invalid
        albums.get(0).addToPlayList(5, playList);

        albums.get(1).addToPlayList("li89", playList);
        albums.get(1).addToPlayList("li22", playList);
        albums.get(1).addToPlayList("li44", playList);
        albums.get(1).addToPlayList("li00", playList);
        albums.get(1).addToPlayList("li10", playList);
        albums.get(1).addToPlayList(7, playList);
        albums.get(1).addToPlayList(23, playList);


        play(playList);

    }


    public static void play(LinkedList<Song> playList) {
        boolean quit = false;
        boolean goForward = true;
        ListIterator<Song> songListIterator = playList.listIterator();
        while (!quit) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0: //Quit
                    System.out.println("Bye");
                    quit = true;
                    break;
                case 1: // Forward
                    if (!goForward) {
                        if (songListIterator.hasNext())
                            songListIterator.next();
                        // goForward = true;
                    }

                    if (songListIterator.hasNext()) {
                        System.out.println("Now playing " + songListIterator.next().toString());
                        goForward = true;
                    } else {
                        System.out.println("You have reached to the end of the list.");
                        goForward = false;
                    }

                    break;
                case 2: //Backwards
                    if (goForward) {
                        if (songListIterator.hasPrevious())
                            songListIterator.previous();
//                        else
//                            System.out.println("You are at the start of the list.");
                        //goForward = false;
                    }

                    if (songListIterator.hasPrevious()) {
                        System.out.println("Now playing " + songListIterator.previous().toString());
                        goForward = false;
                    } else {
                        System.out.println("You are at the start of the list.");
                        //goForward = true;
                    }
                    break;
                case 3: //Replay
                    if (goForward) {
                        if (songListIterator.hasPrevious()) {
                            System.out.println("Now playing " + songListIterator.previous().toString());
                            goForward = false;
                        } else {
                            System.out.println("You are at the start of the list.");
                            //goForward = true;
                        }

                    } else {
                        if (songListIterator.hasNext()) {
                            System.out.println("Now playing " + songListIterator.next().toString());
                            goForward = true;
                        } else {
                            System.out.println("You have reached to the end of the list.");
                        }
                    }

                    break;
                case 4: //List
                    while (songListIterator.hasPrevious()) {
                        songListIterator.previous();
                    }
                    while (songListIterator.hasNext()) {
                        System.out.println(songListIterator.next().toString());
                    }
                    while (songListIterator.hasPrevious()) {
                        songListIterator.previous();
                    }
                    break;
                case 5: //remove
                    if (playList.size() > 0) {
                        songListIterator.remove();
                        if (songListIterator.hasNext()) {
                            System.out.println("Now playing "+ songListIterator.next().toString());
                        }else if (songListIterator.hasPrevious()) {
                            System.out.println("Now playing "+ songListIterator.previous().toString());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Press\n" +
                "0- To quit\n" +
                "1- To skip forward to the next song\n" +
                "2- To skip backwards to a previous song\n" +
                "3- To replay the current song\n" +
                "4- List the songs in the playlist\n" +
                "5- To remove the current song from the playlist");

    }
}
