package com.game.bomberman.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.game.bomberman.model.Characters;

import DAO.ImageDAO;

public class CharactersView extends JPanel {
	private Characters characters;
	private Image img;
	private String name;
	private boolean dead;

	public CharactersView(Characters characters) {
		super();
		this.characters = characters;
		this.name = characters.getName();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		image(g);
		// g.drawRect(characters.recPlayer().x, characters.recPlayer().y,
		// characters.recPlayer().width,
		// characters.recPlayer().height);
	}

	public void image(Graphics g) {
		dead = characters.isDead();
		if (dead) {
			CharDead(g);
			return;
		}
		switch (name) {
		case "bongmo":
			try {
				bongMo(g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:

			break;
		}
	}

	public void bongMo(Graphics g) throws IOException {
		if (characters.getDirectional().equalsIgnoreCase("down")) {
			img = new ImageIcon(getClass().getResource(ImageDAO.bomber_down)).getImage();
			g.drawImage(img, characters.getPosition().getxCoordinate(), characters.getPosition().getyCoordinate(),
					characters.getWidth(), characters.getHeight(), null);
		}
		if (characters.getDirectional().equalsIgnoreCase("up")) {
			img = new ImageIcon(getClass().getResource(ImageDAO.bomber_up)).getImage();
			g.drawImage(img, characters.getPosition().getxCoordinate(), characters.getPosition().getyCoordinate(),
					characters.getWidth(), characters.getHeight(), null);
		}
		if (characters.getDirectional().equalsIgnoreCase("left")) {
			img = new ImageIcon(getClass().getResource(ImageDAO.bomber_left)).getImage();
			g.drawImage(img, characters.getPosition().getxCoordinate(), characters.getPosition().getyCoordinate(),
					characters.getWidth(), characters.getHeight(), null);
		}
		if (characters.getDirectional().equalsIgnoreCase("right")) {
			img = new ImageIcon(getClass().getResource(ImageDAO.bomber_right)).getImage();
			g.drawImage(img, characters.getPosition().getxCoordinate(), characters.getPosition().getyCoordinate(),
					characters.getWidth(), characters.getHeight(), null);
		}
	}

	public void CharDead(Graphics g) {
		img = new ImageIcon(getClass().getResource(ImageDAO.charDead)).getImage();
		g.drawImage(img, characters.getPosition().getxCoordinate(), characters.getPosition().getyCoordinate(),
				characters.getWidth(), characters.getHeight(), null);
	}
}
