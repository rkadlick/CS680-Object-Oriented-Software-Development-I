package edu.umb.cs680.hw06;

public class DrawerClosedPlaying extends DVDPlayer {
	
	public static DVDPlayer getInstance(DVDPlayer p) {
		if(player == null) {
			player = new DrawerClosedPlaying ();
			state = DVDPlayer.getInstance();
		}
		
		return player;
	}

	@Override
	public void openCloseButtonPushed() {
		// TODO Auto-generated method stub
		
		player.stop();
		player.open();
		player.changeState(new DrawerOpen());
		
	}

	@Override
	public void playButtonPushed() {
		// TODO Auto-generated method stub
		
		System.out.println("Nothing happens");
		
		
	}

	@Override
	public void stopButtonPushed() {
		// TODO Auto-generated method stub
		
		player.stop();
		player.changeState(new DrawerClosedNotPlaying());
	}
	
	protected DrawerClosedPlaying() {
		super(state);
	}

}
