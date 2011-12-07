/*
 * Weazzer Android Application
 * 
 */
package weazzer.wear;

/**
 * The Class ClothingArticle that describes a clothing article.
 */
public class ClothingArticle {

	/**
	 * The Enum Type.
	 */
	public enum Type {
		/** Pants or stuff to wear on legs. */
		Pants,
		/** Shirt or stuff to wear on top. */
		Shirt,
		/** Overcoat or jacket etc. */
		Overcoat,
		/** Accessory, like gloves, hat, umbrella, etc. */
		Accessory
	};

	/**
	 * The User Sex.
	 */
	public enum UserSex {
		/** The Male. */
		Male,
		/** The Female. */
		Female
	};

	/** The name of the article. */
	private String name;

	/** The type. */
	private Type type;

	/** The user sex. */
	private UserSex userSex;

	/**
	 * The name of the Android resource of the image (without extension). Should
	 * be something like R.drawable.pants1
	 */
	private int resource;
	
	/**
	 * The name of the Android resource of the grayed image (without extension). Should
	 * be something like R.drawable.pants1_gray
	 */
	private int resourceGray;

	/** The heat factor of the article. */
	private Float heatFactor;

	/* ** METHODS ** */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClothingArticle [heatFactor=" + heatFactor + ", name=" + name
				+ ", resource=" + resource + ", type=" + type + ", userSex="
				+ userSex + "]";
	}

	/**
	 * Instantiates a new clothing article.
	 *
	 * @param name the name
	 * @param type the type
	 * @param userSex the user sex
	 * @param resource the resource
	 * @param heatFactor the heat factor
	 */
	public ClothingArticle(String name, Type type, UserSex userSex,
			int resource, Float heatFactor) {
		this(name, type, userSex, resource, 0, heatFactor);
	}

	/**
	 * Instantiates a new clothing article.
	 *
	 * @param name the name
	 * @param type the type
	 * @param userSex the user sex
	 * @param resource the resource
	 * @param resourceGray the resource gray
	 * @param heatFactor the heat factor
	 */
	public ClothingArticle(String name, Type type, UserSex userSex,
			int resource, int resourceGray, Float heatFactor) {
		super();
		this.name = name;
		this.type = type;
		this.userSex = userSex;
		this.resource = resource;
		this.resourceGray = resourceGray;
		this.heatFactor = heatFactor;
	}	
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * Gets the heat factor.
	 * 
	 * @return the heat factor
	 */
	public Float getHeatFactor() {
		return heatFactor;
	}

	/**
	 * Sets the heat factor.
	 * 
	 * @param heatFactor
	 *            the new heat factor
	 */
	public void setHeatFactor(Float heatFactor) {
		this.heatFactor = heatFactor;
	}

	/**
	 * Gets the user sex.
	 *
	 * @return the userSex
	 */
	public UserSex getUserSex() {
		return userSex;
	}

	/**
	 * Sets the user sex.
	 *
	 * @param userSex the userSex to set
	 */
	public void setUserSex(UserSex userSex) {
		this.userSex = userSex;
	}

	/**
	 * Gets the resource.
	 *
	 * @return the resource
	 */
	public int getResource() {
		return resource;
	}

	/**
	 * Sets the resource.
	 *
	 * @param resource the resource to set
	 */
	public void setResource(int resource) {
		this.resource = resource;
	}

	/**
	 * Gets the resource gray.
	 *
	 * @return the resource gray
	 */
	public int getResourceGray() {
		return resourceGray;
	}

	/**
	 * Sets the resource gray.
	 *
	 * @param resourceGray the new resource gray
	 */
	public void setResourceGray(int resourceGray) {
		this.resourceGray = resourceGray;
	}	
}
