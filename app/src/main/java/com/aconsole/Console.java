package com.aconsole;
import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Console extends ScrollView
{
	private LinearLayout layout;
	private TextView outText;
	private SpannableStringBuilder consoleContent;
	
	private int backgroundColor = Color.BLACK;
	private int textColor = backgroundColor == Color.BLACK ? Color.WHITE : Color.WHITE;

	public Console(Context ctx)
	{
		super(ctx);
		layout = new LinearLayout(ctx);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
		layout.setBackgroundColor(backgroundColor);
		outText = new TextView(ctx);
		outText.setTextColor(textColor);
		consoleContent = new SpannableStringBuilder();

		layout.addView(outText);
		addView(layout);
		setBackgroundColor(backgroundColor);
	}

	public void out(String text)
	{
		int spanStart = consoleContent.length();
		int spanEnd = spanStart + text.length();

		consoleContent.append(text);
		consoleContent.setSpan(new ForegroundColorSpan(textColor), 
				spanStart, spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		outText.setText(consoleContent);
	}

	public void err(String text)
	{
		int spanStart = consoleContent.length();
		int spanEnd = spanStart + text.length();

		consoleContent.append(text);
		consoleContent.setSpan(new ForegroundColorSpan(Color.RED), 
							   spanStart, spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		outText.setText(consoleContent);
	}
	
	public void outln(String text)
	{
		text += "\n";
		int spanStart = consoleContent.length();
		int spanEnd = spanStart + text.length();

		consoleContent.append(text);
		consoleContent.setSpan(new ForegroundColorSpan(textColor), 
							   spanStart, spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		outText.setText(consoleContent);
	}

	public void errln(String text)
	{
		text += "\n";
		int spanStart = consoleContent.length();
		int spanEnd = spanStart + text.length();

		consoleContent.append(text);
		consoleContent.setSpan(new ForegroundColorSpan(Color.RED), 
						spanStart, spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		outText.setText(consoleContent);
	}
}
