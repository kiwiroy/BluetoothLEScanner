package ch.zh.emineo.blerecordparser;

public class BleAdvFields {
	// FLAGS
	public static final byte BLE_ADV_FLAGS = 0x01;

	// SERVICE
	public static final byte BLE_ADV_SERVICE_16_BIT_UUIDS_MOREAVAILABLE = 0x02;
	public static final byte BLE_ADV_SERVICE_16_BIT_UUIDS_COMPELTE = 0x03;
	public static final byte BLE_ADV_SERVICE_32_BIT_UUIDS_MOREAVAILABLE = 0x04;
	public static final byte BLE_ADV_SERVICE_32_BIT_UUIDS_COMPELTE = 0x05;
	public static final byte BLE_ADV_SERVICE_128_BIT_UUIDS_MOREAVAILABLE = 0x06;
	public static final byte BLE_ADV_SERVICE_128_BIT_UUIDS_COMPELTE = 0x07;

	// LOCAL NAME
	public static final byte BLE_ADV_LOCALNAME_SHORTENED = 0x08;
	public static final byte BLE_ADV_LOCALNAME_COMPLETE = 0x09;

	// TX POWER LEVEL
	public static final byte BLE_ADV_TX_POWERLEVEL = 0x0A;

	// SIMPLE PAIRING OPTIONAL OOB TAGS
	public static final byte BLE_ADV_SIMPLEPAIRING_CLASSOFDEVICE = 0x0D;
	public static final byte BLE_ADV_SIMPLEPAIRING_HASH_C = 0x0E;
	public static final byte BLE_ADV_SIMPLEPAIRING_RANDOMIZER_R = 0x0F;

	// SECURITY MANAGER TK VALUE
	public static final byte BLE_ADV_SECURITYMANAGER_TK_VALUE = 0x10;

	// SECURITY MANAGER OOB FLAGS
	public static final byte BLE_ADV_SECURITYMANAGER_OOB_FLAGS = 0x11;

	// SLAVE CONNECTION INTERVAL RANGE
	public static final byte BLE_ADV_SLAVE_CONNECTION_INTERVAL_RANGE = 0x12;

	// SERVICE SOLICITATION
	public static final byte BLE_ADV_SERVICE_SOLICITATION_UUIDS_16_BIT = 0x14;
	public static final byte BLE_ADV_SERVICE_SOLICITATION_UUIDS_128_BIT = 0x15;

	// SERVICE DATA
	public static final byte BLE_ADV_SERVICE_DATA = 0x16;

	// MANUFACTURER SPECIFIC DATA
	public static final byte BLE_ADV_MANUFACTURER_SPECIFIC_DATA = (byte) 0xFF;
}
