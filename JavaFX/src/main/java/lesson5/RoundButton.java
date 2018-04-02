package lesson5;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class RoundButton extends Button implements RoundButtonApi {

	public RoundButton() {
	}

	public RoundButton(int type) {
		setType(type);
	}

	@Override
	public void setType(int type) {
		Circle roundBtnClip = new Circle();
		roundBtnClip.setCenterX(18);
		roundBtnClip.setCenterY(12);
		roundBtnClip.setRadius(8);
		this.setClip(roundBtnClip);
		if (type == 1) {
			setText(" +");
		} else {
			setText(" -");
		}
	}
}
