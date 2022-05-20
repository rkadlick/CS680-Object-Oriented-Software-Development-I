package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;


public class DVDPlayerTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		DVDPlayer.player = null;
	}
	
	@Test
	public void drawerOpenOpenCloseButtonPushed() {
		
		
		DVDPlayer actual = null;
		actual = DrawerOpen.getInstance(actual);
		
		
		
		actual.openCloseButtonPushed();
		
		String expected = "DVD Player - Close\n";
		
		assertEquals(expected, outContent.toString());
		
		
		
		
	}
	
	
	@Test
	public void drawerOpenPlayButtonPushed() {
		
		DVDPlayer actual = null;
		actual = DrawerOpen.getInstance(actual);

		
		actual.playButtonPushed();
		
		String expected = "DVD Player - Close\nDVD Player - Play\n";
		
		assertEquals(expected, outContent.toString());
		
	}
	
	
	@Test
	public void drawerOpenStopButtonPushed() {
		
		DVDPlayer actual = null;
		actual = DrawerOpen.getInstance(actual);

		
		actual.stopButtonPushed();
		
		String expected = "Nothing happens\n";
		
		assertEquals(expected, outContent.toString());
		
	}
	
	
	@Test
	public void drawerClosedPlayingOpenCloseButtonPushed() {
		
		DVDPlayer actual = null;
		actual = DrawerClosedPlaying.getInstance(actual);

		
		actual.openCloseButtonPushed();
		
		String expected = "DVD Player - Stop\nDVD Player - Open\n";
		
		assertEquals(expected, outContent.toString());
		
	}
	
	@Test
	public void drawerClosedPlayingPlayButtonPushed() {
		
		DVDPlayer actual = null;
		actual = DrawerClosedPlaying.getInstance(actual);

		
		actual.playButtonPushed();
		
		String expected = "Nothing happens\n";
		
		assertEquals(expected, outContent.toString());
		
	}
	
	@Test
	public void drawerClosedPlayingStopButtonPushed() {
		
		DVDPlayer actual = null;
		actual = DrawerClosedPlaying.getInstance(actual);

		
		actual.stopButtonPushed();
		
		String expected = "DVD Player - Stop\n";
		
		assertEquals(expected, outContent.toString());
		
	}
	
	
	@Test
	public void drawerClosedNotPlayingOpenCloseButtonPushed() {
		
		DVDPlayer actual = null;
		actual = DrawerClosedNotPlaying.getInstance(actual);

		
		actual.openCloseButtonPushed();
		
		String expected = "DVD Player - Open\n";
		
		assertEquals(expected, outContent.toString());
		
	}
	
	@Test
	public void drawerClosedNotPlayingPlayButtonPushed() {
		
		DVDPlayer actual = null;
		actual = DrawerClosedNotPlaying.getInstance(actual);

		
		actual.playButtonPushed();
		
		String expected = "DVD Player - Play\n";
		
		assertEquals(expected, outContent.toString());
		
	}
	
	@Test
	public void drawerClosedNotPlayingStopButtonPushed() {
		
		DVDPlayer actual = null;
		actual = DrawerClosedNotPlaying.getInstance(actual);

		
		actual.stopButtonPushed();
		
		String expected = "Nothing happens\n";
		
		assertEquals(expected, outContent.toString());
		
	}
	
	@Test
	public void compareInstances() {
		
		DVDPlayer actual = DVDPlayer.getInstance();
		DVDPlayer expected = DVDPlayer.getInstance();
		
		assertSame(expected, actual);
		
	}

	
}
