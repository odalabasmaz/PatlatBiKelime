package com.antibyteapps.patlatbikelime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

import java.util.LinkedHashSet;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

	private LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
	final String alphabet = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";

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
				float currentXPosition = event.getX();
				float currentYPosition = event.getY();
				int position = gridview.pointToPosition((int) currentXPosition, (int) currentYPosition);
				if (position >= 0 && position < 30) {
					hashSet.add(position);
				}
				if (event.getActionMasked() == MotionEvent.ACTION_UP) {
					String word = "";
					for (Integer i : hashSet) {
						word += ((TextView) (gridview.getChildAt(i).findViewById(R.id.textView1))).getText();
					}
//					boolean isWord = ClientService.getInstance().plainRequest(word).contains("true");
					boolean isWord =false;
					if (!isWord) {
						hashSet.clear();
						TextView textWord = (TextView) findViewById(R.id.word);
						textWord.setText(word + " is not a word");
						return false;
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
							((TextView) (gridview.getChildAt(bir * 5).findViewById(R.id.textView1))).setText(String.valueOf(alphabet.charAt(new Random().nextInt(alphabet.length()))));
							bir++;
						} else if ((int) objects[i] % 5 == 1) {
							((TextView) (gridview.getChildAt(iki * 5 + 1).findViewById(R.id.textView1))).setText(String.valueOf(alphabet.charAt(new Random().nextInt(alphabet.length()))));
							iki++;
						} else if ((int) objects[i] % 5 == 2) {
							((TextView) (gridview.getChildAt(uc * 5 + 2).findViewById(R.id.textView1))).setText(String.valueOf(alphabet.charAt(new Random().nextInt(alphabet.length()))));
							uc++;
						} else if ((int) objects[i] % 5 == 3) {
							((TextView) (gridview.getChildAt(dort * 5 + 3).findViewById(R.id.textView1))).setText(String.valueOf(alphabet.charAt(new Random().nextInt(alphabet.length()))));
							dort++;
						} else if ((int) objects[i] % 5 == 4) {
							((TextView) (gridview.getChildAt(bes * 5 + 4).findViewById(R.id.textView1))).setText(String.valueOf(alphabet.charAt(new Random().nextInt(alphabet.length()))));
							bes++;
						}
					}

					TextView textWord = (TextView) findViewById(R.id.word);
					textWord.setText(word);
					hashSet.clear();
				}
				return false;
			}
		});

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
