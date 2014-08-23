package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exception.IORuntimeException;

public abstract class AbstractUi {
	protected String getInputedString(){
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try{
			return input.readLine();
		} catch (IOException e){
			throw new IORuntimeException("�ֿܼ� �Է��� ���� ���߽��ϴ�.",e);
		}
	}
	
	abstract public void show();
}