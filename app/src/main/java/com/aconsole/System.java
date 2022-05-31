package com.aconsole;
import android.app.Activity;
import android.content.Context;

public abstract class System
{
	public static Console console;
	public static OutStream out;
	public static ErrStream err;

	public static void setConsole(Console console)
	{
		System.console = console;
		out = new OutStream(console.getContext());
		err = new ErrStream(console.getContext());
	}
	
	public static class OutStream
	{
		public Activity app;
	
		public OutStream(Context ctx)
		{
			app = (Activity) ctx;
		}
		
		public void print(final String text)
		{
			app.runOnUiThread(new Runnable()
				{
					@Override
					public void run()
					{
						console.out(text);
					}
				});
		}
		
		public void println(final String text)
		{
			app.runOnUiThread(new Runnable()
				{
					@Override
					public void run()
					{
						console.outln(text);
					}
				});
		}
	}
	
	public static class ErrStream
	{
		public Activity app;

		public ErrStream(Context ctx)
		{
			app = (Activity) ctx;
		}

		public void print(final String text)
		{
			app.runOnUiThread(new Runnable()
				{
					@Override
					public void run()
					{
						console.err(text);
					}
				});
		}

		public void println(final String text)
		{
			app.runOnUiThread(new Runnable()
				{
					@Override
					public void run()
					{
						console.errln(text);
					}
				});
		}
	}
}
