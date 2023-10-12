/*
 *   Copyright (c) 2021 Martijn van Welie
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *   SOFTWARE.
 *
 */

package com.welie.blessed;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

import org.jetbrains.annotations.NotNull;

/**
 * Callbacks for the BluetoothPeripheral class
 * 蓝牙外设类的回调
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class BluetoothPeripheralCallback {

    /**
     * Callback invoked when the list of remote services, characteristics and descriptors
     * for the remote peripheral has been discovered.
     * 当远程服务、特征和描述符列表时调用的回调
     *       * 已发现远程外设。
     *
     */
    public void onServicesDiscovered(@NotNull BluetoothPeripheral peripheral) {}

    /**
     * Callback invoked when the notification state of a characteristic has changed.
     *  获取特性的当前通知状态
     * <p>Use {@link BluetoothPeripheral#isNotifying} to get the current notification state of the characteristic
     *
     * @param peripheral the peripheral 外设
     * @param characteristic the characteristic for which the notification state changed 通知状态改变的特征
     * @param status GATT status code
     */
    public void onNotificationStateUpdate(@NotNull BluetoothPeripheral peripheral, @NotNull BluetoothGattCharacteristic characteristic, @NotNull GattStatus status) {}

    /**
     * Callback invoked as the result of a characteristic read operation or notification/indication
     * 作为特征读取操作或通知/指示的结果调用的回调
     * @param peripheral the peripheral
     * @param value the new value received
     * @param characteristic the characteristic for which the new value was received
     * @param status GATT status code
     */
    public void onCharacteristicUpdate(@NotNull BluetoothPeripheral peripheral, @NotNull byte[] value, @NotNull BluetoothGattCharacteristic characteristic, @NotNull GattStatus status) {}

    /**
     * Callback invoked as the result of a characteristic write operation.
     * 作为特征写入操作的结果调用的回调。
     * @param peripheral the peripheral
     * @param value the value that was written
     * @param characteristic the characteristic written to
     * @param status GATT status code
     */
    public void onCharacteristicWrite(@NotNull BluetoothPeripheral peripheral, @NotNull byte[] value, @NotNull BluetoothGattCharacteristic characteristic, @NotNull GattStatus status) {}

    /**
     * Callback invoked as the result of a descriptor read operation
     * 作为描述符读取操作的结果调用的回调
     * @param peripheral the peripheral
     * @param value the read value
     * @param descriptor the descriptor that was read
     * @param status GATT status code
     */
    public void onDescriptorRead(@NotNull BluetoothPeripheral peripheral, @NotNull byte[] value, @NotNull BluetoothGattDescriptor descriptor, @NotNull GattStatus status) {}

    /**
     * Callback invoked as the result of a descriptor write operation.
     * This callback is not called for the Client Characteristic Configuration descriptor. Instead the {@link BluetoothPeripheralCallback#onNotificationStateUpdate(BluetoothPeripheral, BluetoothGattCharacteristic, GattStatus)} will be called
     *
     * 作为描述符写入操作的结果调用的回调。
     *       * 客户端特征配置描述符不会调用此回调。 相反，将调用
     *       {@link BluetoothPeripheralCallback#onNotificationStateUpdate(BluetoothPeripheral, BluetoothGattCharacteristic, GattStatus)}
     * @param peripheral the peripheral
     * @param value the value that was written
     * @param descriptor the descriptor written to
     * @param status the GATT status code
     */
    public void onDescriptorWrite(@NotNull BluetoothPeripheral peripheral, @NotNull byte[] value, @NotNull BluetoothGattDescriptor descriptor, @NotNull GattStatus status) {}

    /**
     * Callback invoked when the bonding process is started
     *绑定过程启动时调用的回调
     * @param peripheral the peripheral
     */
    public void onBondingStarted(@NotNull BluetoothPeripheral peripheral) {}

    /**
     * Callback invoked when the bonding process has succeeded
     *绑定过程成功时调用的回调
     * @param peripheral the peripheral
     */
    public void onBondingSucceeded(@NotNull BluetoothPeripheral peripheral) {}

    /**
     * Callback invoked when the bonding process has failed
     *绑定过程失败时调用的回调
     * @param peripheral the peripheral
     */
    public void onBondingFailed(@NotNull BluetoothPeripheral peripheral) {}

    /**
     * Callback invoked when a bond has been lost and the peripheral is not bonded anymore.
     *当绑定丢失并且外设不再绑定时调用回调。
     * @param peripheral the peripheral
     */
    public void onBondLost(@NotNull BluetoothPeripheral peripheral) {}

    /**
     * Callback invoked as the result of a read RSSI operation
     *作为读取 RSSI(信号强度) 操作结果而调用的回调
     * @param peripheral the peripheral
     * @param rssi the RSSI value
     * @param status GATT status code
     */
    public void onReadRemoteRssi(@NotNull BluetoothPeripheral peripheral, int rssi, @NotNull GattStatus status) {}

    /**
     * Callback invoked as the result of a MTU request operation
     * MTU：最大传输单元
     * @param peripheral the peripheral
     * @param mtu the new MTU
     * @param status GATT status code
     */
    public void onMtuChanged(@NotNull BluetoothPeripheral peripheral, int mtu, @NotNull GattStatus status) {}

    /**
     * Callback invoke as result of readPhy or setPhy operation
     * 作为 readPhy 或 setPhy 操作结果的回调调用
     *
     * @param peripheral the peripheral
     * @param txPhy the transmitter PHY in use.
     * @param rxPhy the receiver PHY in use
     * @param status GATT status code
     */
    public void onPhyUpdate(@NotNull BluetoothPeripheral peripheral, @NotNull PhyType txPhy, @NotNull PhyType rxPhy, @NotNull GattStatus status) {}

    /**
     * Callback invoked when the connection parameters are updated.
     *
     * This can happen as a result of requestConnectionPriority() or when the stack/peripheral decides to change the connection parameters.
     * This callback is only called for Android 8 (Oreo) or newer.
     * 连接参数更新时调用的回调。
     *       *
     *       * 这可能是由于 requestConnectionPriority() 的结果或当堆栈/外设决定更改连接参数时发生的。
     *       * 此回调仅针对 Android 8 (Oreo) 或更高版本调用。
     *
     * @param peripheral the peripheral
     * @param interval Connection interval used on this connection, 1.25ms unit.
     *                 Valid range is from 6 (7.5ms) to 3200 (4000ms).
     * @param latency  Slave latency for the connection in number of connection events.
     *                 Valid range is from 0 to 499.
     * @param timeout  Supervision timeout for this connection, in 10ms unit.
     *                 Valid range is from 10 (0.1s) to 3200 (32s).
     * @param status GATT status code
     */
    public void onConnectionUpdated(@NotNull BluetoothPeripheral peripheral, int interval, int latency, int timeout, @NotNull GattStatus status) {}

    /**
     * NULL class to deal with nullability
     */
    static class NULL extends BluetoothPeripheralCallback { }
}
