package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class OfferContainer implements Serializable {
	
	private static final long serialVersionUID = -5934404983871750457L;

	private ArrayList<Offer> offers;
	
	private static OfferContainer instance = null;

	protected OfferContainer() {
		offers = new ArrayList<Offer>();
	}

	public static OfferContainer getInstance() {
		if (instance == null) {
			instance = new OfferContainer();
		}
		return instance;
	}
	
	public void addOffer(Offer offer)
	{
		offers.add(offer);
	}
	
	public void removeOffer(Offer offer)
	{
		offers.remove(offer);
	}
	
	public Offer getOffer(int ID)
	{
		for(Offer offer : offers)
		{
			if(offer.getID() == ID)
				return offer;
		}
		
		return null;
	}
	
	public ArrayList<Offer> getOffers(Date startDate, Date endDate) {
		ArrayList<Offer> newoffers = new ArrayList<Offer>();
		for(Offer offer : offers) {
			if(offer.getStartDate().after(startDate) && offer.getStartDate().before(endDate) &&
				offer.getEndDate().after(startDate) && offer.getEndDate().before(endDate)	)
				newoffers.add(offer);
		}
		
		return newoffers;
	}

}
