/* DO NOT EDIT THIS FILE - IT IS MACHINE GENERATED */

/*
 * Copyright (C) 2013 Samuel Audet
 *
 * This file is part of JavaCPP.
 *
 * JavaCPP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version (subject to the "Classpath" exception
 * as provided in the LICENSE.txt file that accompanied this code).
 *
 * JavaCPP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JavaCPP.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.*;
import com.googlecode.javacpp.annotation.*;
import java.nio.*;

import static com.googlecode.javacv.cpp.avutil.*;
import static com.googlecode.javacv.cpp.avcodec.*;
import static com.googlecode.javacv.cpp.avformat.*;
import static com.googlecode.javacv.cpp.postproc.*;
import static com.googlecode.javacv.cpp.swresample.*;
import static com.googlecode.javacv.cpp.swscale.*;
import static com.googlecode.javacv.cpp.avfilter.*;

/**
 *
 * @author Samuel Audet
 */
@Properties(inherit=avfilter.class, value={
    @Platform(cinclude="<libavdevice/avdevice.h>", link="avdevice@.55"),
    @Platform(value="windows", preload="avdevice-55") })
public class avdevice {
    static { Loader.load(); }

/* Wrapper for header file /usr/local/include/libavdevice/avdevice.h */

/*
 * This file is part of FFmpeg.
 *
 * FFmpeg is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * FFmpeg is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with FFmpeg; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */

// #ifndef AVDEVICE_AVDEVICE_H
// #define AVDEVICE_AVDEVICE_H

// #include "version.h"

/**
 * @file
 * @ingroup lavd
 * Main libavdevice API header
 */

/**
 * @defgroup lavd Special devices muxing/demuxing library
 * @{
 * Libavdevice is a complementary library to @ref libavf "libavformat". It
 * provides various "special" platform-specific muxers and demuxers, e.g. for
 * grabbing devices, audio capture and playback etc. As a consequence, the
 * (de)muxers in libavdevice are of the AVFMT_NOFILE type (they use their own
 * I/O functions). The filename passed to avformat_open_input() often does not
 * refer to an actually existing file, but has some special device-specific
 * meaning - e.g. for x11grab it is the display name.
 *
 * To use libavdevice, simply call avdevice_register_all() to register all
 * compiled muxers and demuxers. They all use standard libavformat API.
 * @}
 */

// #include "libavformat/avformat.h"

/**
 * Return the LIBAVDEVICE_VERSION_INT constant.
 */
public static native @Cast("unsigned") int avdevice_version();

/**
 * Return the libavdevice build-time configuration.
 */
public static native @Cast("const char*") BytePointer avdevice_configuration();

/**
 * Return the libavdevice license.
 */
public static native @Cast("const char*") BytePointer avdevice_license();

/**
 * Initialize libavdevice and register all the input and output devices.
 * @warning This function is not thread safe.
 */
public static native void avdevice_register_all();

// #endif /* AVDEVICE_AVDEVICE_H */


}
