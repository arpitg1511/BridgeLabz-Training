package model;

import java.time.LocalDate;

public class Bill {

	private int id;
	private int visitId;
	private double consultationFee;
	private double additionalCharges;
	private double totalAmount;
	private String paymentStatus;
	private LocalDate billDate;

	public Bill(int visitId, double consultationFee, double additionalCharges, double totalAmount, String paymentStatus,
			LocalDate billDate) {

		this.visitId = visitId;
		this.consultationFee = consultationFee;
		this.additionalCharges = additionalCharges;
		this.totalAmount = totalAmount;
		this.paymentStatus = paymentStatus;
		this.billDate = billDate;
	}

	public int getVisitId() {
		return visitId;
	}

	public double getConsultationFee() {
		return consultationFee;
	}

	public double getAdditionalCharges() {
		return additionalCharges;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public LocalDate getBillDate() {
		return billDate;
	}
}