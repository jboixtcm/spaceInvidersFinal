package com.space.game.utilities;

public interface ISubject {

	public void addObserver(IObserver observer) throws InvalidParamException;

	public void notifyObservers();
}
