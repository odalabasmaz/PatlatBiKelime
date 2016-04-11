package com.antibyteapps.patlatbikelime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.antibyteapps.services.ClientService;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.LinkedHashSet;
import java.util.Random;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

	private LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
	private static final String ALPHABET = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";
	private static final ClientService CLIENT = ClientService.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		final GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new CustomGridViewAdapter(this));

		gridview.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				doTouchAction(gridview, event);
				return false;
			}
		});
	}

	private void doTouchAction(final GridView gridview, MotionEvent event) {
		float currentXPosition = event.getX();
		float currentYPosition = event.getY();
		int position = gridview.pointToPosition((int) currentXPosition, (int) currentYPosition);
		if (position >= 0 && position < 30) {
			hashSet.add(position);
		}
		if (event.getActionMasked() != MotionEvent.ACTION_UP) {
			return;
		}

		final StringBuilder sb = new StringBuilder();
		for (Integer i : hashSet) {
			sb.append(((TextView) (gridview.getChildAt(i).findViewById(R.id.textView1))).getText());
		}

		CLIENT.checkWord(sb.toString(), new TextHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers, String responseBody) {
				boolean isWord = "true".equals(responseBody);
				checkResponse(sb.toString(), isWord, gridview);
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, String responseBody, Throwable error) {

			}
		});
	}

	private void checkResponse(String word, boolean isWord, GridView gridview) {
		if (!isWord) {
			hashSet.clear();
			TextView textWord = (TextView) findViewById(R.id.word);
			textWord.setText(word + " is not a word!");
			return;
		}
		for (int j = 0; j < 5; j++) {
			for (int i = 20 + j, k = 0; i >= j; i = i - 5) {
				if (hashSet.contains(i)) {
					k++;
				} else {
					((TextView) (gridview.getChildAt(i + k * 5).findViewById(R.id.textView1))).setText(((TextView) (gridview.getChildAt(i).findViewById(R.id.textView1))).getText());
				}
			}
		}
		int bir = 0, iki = 0, uc = 0, dort = 0, bes = 0;
		Object[] objects = hashSet.toArray();
		for (int i = 0; i < objects.length; i++) {
			if ((int) objects[i] % 5 == 0) {
				((TextView) (gridview.getChildAt(bir * 5).findViewById(R.id.textView1))).setText(String.valueOf(ALPHABET.charAt(new Random().nextInt(ALPHABET.length()))));
				bir++;
			} else if ((int) objects[i] % 5 == 1) {
				((TextView) (gridview.getChildAt(iki * 5 + 1).findViewById(R.id.textView1))).setText(String.valueOf(ALPHABET.charAt(new Random().nextInt(ALPHABET.length()))));
				iki++;
			} else if ((int) objects[i] % 5 == 2) {
				((TextView) (gridview.getChildAt(uc * 5 + 2).findViewById(R.id.textView1))).setText(String.valueOf(ALPHABET.charAt(new Random().nextInt(ALPHABET.length()))));
				uc++;
			} else if ((int) objects[i] % 5 == 3) {
				((TextView) (gridview.getChildAt(dort * 5 + 3).findViewById(R.id.textView1))).setText(String.valueOf(ALPHABET.charAt(new Random().nextInt(ALPHABET.length()))));
				dort++;
			} else if ((int) objects[i] % 5 == 4) {
				((TextView) (gridview.getChildAt(bes * 5 + 4).findViewById(R.id.textView1))).setText(String.valueOf(ALPHABET.charAt(new Random().nextInt(ALPHABET.length()))));
				bes++;
			}
		}

		TextView textWord = (TextView) findViewById(R.id.word);
		textWord.setText(word);
		hashSet.clear();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
