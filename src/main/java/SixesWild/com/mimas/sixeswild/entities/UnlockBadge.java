package SixesWild.com.mimas.sixeswild.entities;

public class UnlockBadge extends Badge {

	public UnlockBadge(String name, String description, boolean isUnlocked) {
		super(name, description, isUnlocked);
		this.name = "Master Key";
		this.description = "Unlocked all story levels.";
		this.isUnlocked = false;
	}

}
