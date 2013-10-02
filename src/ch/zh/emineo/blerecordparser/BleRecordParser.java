package ch.zh.emineo.blerecordparser;

import java.util.ArrayList;
import java.util.List;

import android.bluetooth.BluetoothDevice;
import android.util.Log;

public class BleRecordParser {
	private BluetoothDevice mDevice;
	private int mRssi;
	private byte[] mScanRecord;

	public BleRecordParser(final BluetoothDevice device, final int rssi,
			final byte[] scanRecord) {
		setParams(device, rssi, scanRecord);
	}

	public void parse() {
		if (mScanRecord == null || mScanRecord.length == 0) {
			Log.e("printr", this.getClass().getName()
					+ " parse(): please set a valid scan record");
			return;
		}

		int msglength = 0;
		byte msgtype = 0x00;

		List<Byte> msg = new ArrayList<Byte>();

		boolean getLength = true;
		boolean getType = false;
		boolean getMessage = false;

		for (int i = 0; i < mScanRecord.length; i++) {
			if (getLength) {
				msg.clear();
				msglength = (int) (mScanRecord[i] & 0xFF);

				getLength = false;
				getType = true;
				getMessage = false;
				continue;
			}
			if (getType) {
				msgtype = mScanRecord[i];
				
				getLength = false;
				getType = false;
				getMessage = true;
				continue;
			}
			if (getMessage) {
				msg.add(mScanRecord[i]);

				getLength = false;
				getType = false;
				getMessage = true;

				// finished collecting message
				if (msg.size() == (msglength - 1)) {
					getLength = true;
					getType = false;
					getMessage = false;
					
					proceedData(msgtype, msg);
				}
				continue;
			}
		}
	}

	private void proceedData(byte msgtype, List<Byte> msg) {
		//TODO implement all cases
		switch(msgtype) {
		case BleAdvFields.BLE_ADV_FLAGS:
			
			break;
		case BleAdvFields.BLE_ADV_LOCALNAME_COMPLETE:
			Log.d("printr", "BLE_ADV_LOCALNAME_COMPLETE: " + byteListToString(msg).trim());
			break;
		case BleAdvFields.BLE_ADV_LOCALNAME_SHORTENED:
			Log.d("printr", "BLE_ADV_LOCALNAME_SHORTENED: " + byteListToString(msg).trim());
			break;
		case BleAdvFields.BLE_ADV_MANUFACTURER_SPECIFIC_DATA:
			
			break;
		case BleAdvFields.BLE_ADV_SECURITYMANAGER_OOB_FLAGS:
			
			break;
		case BleAdvFields.BLE_ADV_SECURITYMANAGER_TK_VALUE:
			
			break;
		case BleAdvFields.BLE_ADV_SERVICE_128_BIT_UUIDS_COMPELTE:
			
			break;
		case BleAdvFields.BLE_ADV_SERVICE_128_BIT_UUIDS_MOREAVAILABLE:
			
			break;
		case BleAdvFields.BLE_ADV_SERVICE_16_BIT_UUIDS_COMPELTE:
			
			break;
		case BleAdvFields.BLE_ADV_SERVICE_16_BIT_UUIDS_MOREAVAILABLE:
			
			break;
		case BleAdvFields.BLE_ADV_SERVICE_32_BIT_UUIDS_COMPELTE:
			
			break;
		case BleAdvFields.BLE_ADV_SERVICE_32_BIT_UUIDS_MOREAVAILABLE:
			
			break;
		case BleAdvFields.BLE_ADV_SERVICE_DATA:
			
			break;
		case BleAdvFields.BLE_ADV_SERVICE_SOLICITATION_UUIDS_128_BIT:
			
			break;
		case BleAdvFields.BLE_ADV_SERVICE_SOLICITATION_UUIDS_16_BIT:
			
			break;
		case BleAdvFields.BLE_ADV_SIMPLEPAIRING_CLASSOFDEVICE:
			
			break;
		case BleAdvFields.BLE_ADV_SIMPLEPAIRING_HASH_C:
			
			break;
		case BleAdvFields.BLE_ADV_SIMPLEPAIRING_RANDOMIZER_R:
			
			break;
		case BleAdvFields.BLE_ADV_SLAVE_CONNECTION_INTERVAL_RANGE:
			
			break;
		case BleAdvFields.BLE_ADV_TX_POWERLEVEL:
			
			break;
		}
	}

	public static String byteListToString(List<Byte> l) {
		if (l == null) {
			return "";
		}

		byte[] array = new byte[l.size()];
		int i = 0;

		for (Byte current : l) {
			array[i] = current;
			i++;
		}

		return new String(array);
	}

	public static String byteArrayToHex(byte[] a) {
		StringBuilder sb = new StringBuilder();
		for (byte b : a) {
			sb.append(String.format("%02x", b & 0xff) + " ");
		}
		return sb.toString();
	}

	public void setParams(BluetoothDevice device, int rssi, byte[] scanRecord) {
		mDevice = device;
		mRssi = rssi;
		mScanRecord = scanRecord;
	}

	public BluetoothDevice getDevice() {
		return mDevice;
	}

	public int getRssi() {
		return mRssi;
	}

	public byte[] getScanRecord() {
		return mScanRecord;
	}
}
