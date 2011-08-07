package com.swarm.mathPhysicsEngine;

public class Camera {

	private static double x = 240;
	private static double y = 240;
	private static double z = 100;
	private static FourPointMatrix perspectiveMatrix = new FourPointMatrix();

	private static double theta = x;
	private static double phi = y;
	private static double rho = z;

	private static double sinTheta = Math.sin(Math.toRadians(theta));
	private static double cosTheta = Math.cos(Math.toRadians(theta));
	private static double sinPhi = Math.sin(Math.toRadians(phi));
	private static double cosPhi = Math.cos(Math.toRadians(phi));

	public Camera() {
		setPerspectiveMatrix();
	}
	
	
	// Set Matrix values
	public static void setPerspectiveMatrix() {
		perspectiveMatrix.setA1(-sinTheta);
		perspectiveMatrix.setA2(-cosTheta * cosPhi);
		perspectiveMatrix.setA3(-cosTheta * sinPhi);
		perspectiveMatrix.setA4(0);
		perspectiveMatrix.setB1(cosTheta);
		perspectiveMatrix.setB2(-sinTheta * cosPhi);
		perspectiveMatrix.setB3(-sinTheta * sinPhi);
		perspectiveMatrix.setB4(0);
		perspectiveMatrix.setC1(0);
		perspectiveMatrix.setC2(sinPhi);
		perspectiveMatrix.setC3(-cosPhi);
		perspectiveMatrix.setC4(0);
		perspectiveMatrix.setD1(0);
		perspectiveMatrix.setD2(0);
		perspectiveMatrix.setD3(rho);
		perspectiveMatrix.setD4(1);
	}

	private static void calculateCamera() {
		theta = x;
		phi = y;
		rho = z;
		sinTheta = Math.sin(Math.toRadians(theta));
		cosTheta = Math.cos(Math.toRadians(theta));
		sinPhi = Math.sin(Math.toRadians(phi));
		cosPhi = Math.cos(Math.toRadians(phi));

		setPerspectiveMatrix();
	}

	public static FourPointMatrix getPerspectiveMatrix() {
		return perspectiveMatrix;
	}

	public static void setPerspectiveMatrix(FourPointMatrix perspectiveMatrix) {
		Camera.perspectiveMatrix = perspectiveMatrix;
	}

	public static double getRho() {
		return rho;
	}

	public static void setRho(double rho) {
		Camera.rho = rho;
	}

	public static double getX() {
		return x;
	}

	public static double getY() {
		return y;
	}

	public static double getZ() {
		return z;
	}

	public static void setX(double inX) {
		x = inX;
		calculateCamera();
	}

	public static void setY(double inY) {
		y = inY;
		calculateCamera();
	}

	public static void setZ(double inZ) {
		z = inZ;
		calculateCamera();
	}

	public static double getTheta() {
		return theta;
	}

	public static double getPhi() {
		return phi;
	}

	public static double getSinTheta() {
		return sinTheta;
	}

	public static double getCosTheta() {
		return cosTheta;
	}

	public static double getSinPhi() {
		return sinPhi;
	}

	public static double getCosPhi() {
		return cosPhi;
	}

	public static void setTheta(double theta) {
		Camera.theta = theta;
	}

	public static void setPhi(double phi) {
		Camera.phi = phi;
	}

	public static void setSinTheta(double sinTheta) {
		Camera.sinTheta = sinTheta;
	}

	public static void setCosTheta(double cosTheta) {
		Camera.cosTheta = cosTheta;
	}

	public static void setSinPhi(double sinPhi) {
		Camera.sinPhi = sinPhi;
	}

	public static void setCosPhi(double cosPhi) {
		Camera.cosPhi = cosPhi;
	}

}
