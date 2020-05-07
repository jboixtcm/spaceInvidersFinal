package com.space.game.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.space.game.controller.GameController;
import com.space.game.utilities.ConstantUtilities;
import com.space.game.utilities.IObserver;
import com.space.game.utilities.InvalidParamException;

public class ScorePanel extends JPanel implements IObserver {

	private static final int LBL_WIDTH = 200;
	private static final int LBL_HEIGHT = 30;

	private JLabel invadersLbl;
	private JLabel missilesLbl;

	public ScorePanel() {
		setBackground(new Color(180, 180, 180));

		initInvaidersLabel(0);
		initMissilesLabel(ConstantUtilities.MAX_MISSILES);

		add(Box.createHorizontalStrut(10));

	}

	private void initInvaidersLabel(int invidersShot) {
		invadersLbl = new JLabel();
		setTextInvaiders(0);
		invadersLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
		add(invadersLbl);
	}

	private void setTextInvaiders(int invidersShot) {
		invadersLbl.setText("Invaders shot down: " + invidersShot);
	}

	private void setTextMissiles(int missilesRemaining) {
		missilesLbl.setText("Missiles remaining: " + missilesRemaining);
	}

	private void initMissilesLabel(int missilesRemaining) {
		missilesLbl = new JLabel();
		setTextMissiles(ConstantUtilities.MAX_MISSILES);
		missilesLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
		add(missilesLbl);
	}

	@Override
	public void update() {
		GameController game;
		try {
			game = GameController.getInstance();
			setTextInvaiders(game.getNumInvadersDestroyed());
			setTextMissiles(ConstantUtilities.MAX_MISSILES - game.getNumMissiles());

			repaint();

		} catch (InvalidParamException e) {
			e.printStackTrace();
		}
	}
}
