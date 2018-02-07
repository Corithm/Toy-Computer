/*
 * Copyright 2018 C. H. Lay (Corithm)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package main.hardware;

import main.tool.Binary;

import java.util.Hashtable;

/**
 * Memory implementation.
 *
 * Addresses [0, 16_383] are reserved for system, [16_384, 24_575] for screen and 24_576 for keyboard key.
 */
public class Memory
{
    //TODO: Use RAM classes.
    private Hashtable<String, Binary> memory = new Hashtable<>(24_576);

    /**
     * Writes data to memory.
     * 0 - 16 383: RAM16K
     * 16 384 - 24 575: Screen Memory Map 8K
     * 24576: Keyboard memory map
     *
     * @param data to write
     * @param address for data
     */
    public void input(Binary address, Binary data, boolean load)
    {
        if (load) {
            memory.put(address.toString(), data);
        }
    }

    /**
     * Returns the value in the address.
     *
     * @param address the address where information is
     * @return value in the given address or null if not found.
     */
    public Binary out(Binary address) { return memory.get(address.toString()); }

    /**
     * Returns the value in the address.
     *
     * @param address the location of information
     * @return value in the given address or null if not found
     */
    public Binary out(int address) { return out(new Binary(address)); }
}
