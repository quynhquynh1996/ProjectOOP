package com.game.bomberman.view;

import javax.swing.JLayeredPane;

@SuppressWarnings("serial")
public class LayerComponent extends JLayeredPane {
	
	
	public LayerComponent() {
		add(new HighScorePanel(),JLayeredPane.POPUP_LAYER);
	}

}
