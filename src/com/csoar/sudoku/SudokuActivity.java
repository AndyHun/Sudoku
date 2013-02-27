package com.csoar.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class SudokuActivity extends Activity implements OnClickListener {
	private static final String TAG = "SUDOKU";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.settings:
			startActivity(new Intent(this, Settings.class));
			return true;
		default:
			break;
		}
		return false;
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.new_game_button:
			break;
		case R.id.about_button:
			Intent intent = new Intent(this, About.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	private void setListener() {
		View continueButtonView = this.findViewById(R.id.continue_button);
		View newGameButtonView = this.findViewById(R.id.new_game_button);
		View aboutButtonView = this.findViewById(R.id.about_button);
		View exitButtonView = this.findViewById(R.id.exit_button);

		continueButtonView.setOnClickListener(this);
		newGameButtonView.setOnClickListener(this);
		aboutButtonView.setOnClickListener(this);
		exitButtonView.setOnClickListener(this);
	}

	private void openNewGameDialog() {
		new AlertDialog.Builder(this)
				.setTitle(R.string.new_game_title)
				.setItems(R.array.difficulty,
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialogInterface, int i) {
								// startGame(i);
							}
						}).show();
	}

	private void startGame(int i) {
		Log.d(TAG, "Clicked on " + i);
	}
}