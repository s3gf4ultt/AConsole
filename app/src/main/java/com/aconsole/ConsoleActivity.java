package com.aconsole;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ConsoleActivity extends Activity implements MainFunc, Runnable
{
	private Console console;
	private Thread thread;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		thread = new Thread(this);

		console = new Console(this);
		setContentView(console);
		System.setConsole(console);
		
		thread.start();
	}

	@Override
	public void main(String[] args)
	{
	}

	@Override
	public void run()
	{
		try
		{
		main(null);
		}
		catch(Exception e)
		{
			System.err.println(e.toString());
		}
	}
}
