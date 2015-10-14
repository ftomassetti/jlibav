# Java wrapper for Libav #

This library provides an access to a big part of the Libav functions via BridJ. **It is compatible with all Libav binaries since version 0.7.** The goal of this project is to cover complete functionality of the Libav. (Note: the Libav binaries are not a part of this library)

## Features ##
  * Support for most common Libav functions (decoding, encoding, ...)
  * Support for audio and video playback via SWING and Java Sound API
  * Own RTSP server
  * Binary independent (compatible with all Libav binaries since the 0.7 version)
  * Multiplatform

## Version matrix ##
Following table shows which versions of Libav are currently supported by particular jlibav versions.

| **jlibav / Libav** | 0.7.x | 0.8.x | 9.x | master |
|:-------------------|:------|:------|:----|:-------|
| 0.1.x              | ●     |       |     |        |
| 0.2.x              | ●     | ●     | ●   |        |
| 0.3-SNAPSHOT       | ●     | ●     | ●   | ●<sup>1</sup> |

_1: It may be still buggy due to the new Libav API._

## Download ##

If you are using Maven, you can simply add the following dependency:

```
    <dependency>
      <groupId>com.google.code.jlibav</groupId>
      <artifactId>jlibav</artifactId>
      <version>0.2.1</version>
    </dependency>
```

or you can use the snapshot which reflects the main trunk:

```
    <dependency>
      <groupId>com.google.code.jlibav</groupId>
      <artifactId>jlibav</artifactId>
      <version>0.3-SNAPSHOT</version>
    </dependency>
```

You have to also add the following repository if you want to use the snapshot:

```
    <repository>
      <id>sonatype</id>
      <name>Sonatype OSS Snapshots Repository</name>
      <url>http://oss.sonatype.org/content/groups/public</url>
    </repository>
```

You can also download the library manually from the download section or directly from the [repository](https://oss.sonatype.org/content/groups/public/com/google/code/jlibav/jlibav/).

# News #

## 01/30/2014 ##

The Git repo survey results:
  * GitHub - 87.5%
  * Google Code - 12.5%

According to the results, the repository has been moved to [GitHub](https://github.com/operutka/jlibav). The old Google Code repo remains accessible but there won't be any further commits. Please, use the GitHub page also for any new bug reports.

## 09/14/2013 ##

Jlibav version 0.2.1 has been released. Following bugs have been fixed:
  * missing packet timestamps when using avcodec\_encode\_video()
  * bad timestamps of encoded audio/video frames in some containers
  * incorrect order of some operations (mainly responsible for buggy H.264 encoding)
  * insufficient encoding buffer size in some cases
  * incorrect handling of planar audio formats
  * some minor problems related to property cache and plane size alignment in the AVFrame wrappers
  * no error on attempt to allocate a picture of invalid size

## 09/09/2013 ##

Except usual dose of fixes the master branch has been ported to the new BridJ version 0.7-SNAPSHOT. There is also a new quick start sample related to encoding.

## 05/13/2013 ##

There are several changes since the last time (mostly in the snapshot). The most significant is related to encoding. Now it is much more reliable than before. Also codec IDs were changed into enum to be more resilient to ID changes.

## 01/24/2013 ##

A new version has been finally released! 0.2 is based on BridJ instead of JNA and it has lots of improvements compared to its predecessor. It supports all Libav versions since 0.7.

There are also some bug fixes, performance optimizations and new features since last time. Here is a brief list (more info in the git log):
  * new features:
    * support for the new avresample library
    * AVOption handlers
    * channel layout support
  * fixes:
    * PCM audio encoding using Libav 0.7
    * extended\_data warning ([issue #4](https://code.google.com/p/jlibav/issues/detail?id=#4))
    * memory leak in DefaultMediaReader
    * channel layout in DefaultMediaWriter
    * segfault regression caused by the old audio resampling API in PlaybackSample
    * segfault regression in frame resampling (old Libav versions segfaults while resampling with SWS\_FAST\_BILINEAR flag)
    * planar audio stream issue in the RtspServerTest and the RtspSample


## 08/19/2012 ##

A support for metadata, chapters and attached pictures has been added.

## 08/17/2012 ##

The library has been ported to Maven build system and the A/V synchronization bug has been finally fixed.

## 06/07/2012 ##

The whole library has been ported to the BridJ library. BridJ offers better performance  than JNA and there are also some assembler optimizations for native calls. Thank Andres Mejia for the tip.

## 06/01/2012 ##
Today I made big changes:
  * The VCS has been switched to the Git to allow more open development.
  * The license has been changed to the LGPL v3 to avoid any discussion about (in)compatibility with the Libav license.
  * The seek support has been made working.
  * A major memory leak has been fixed.
  * The first official release is available to download.

Unfortunately all wiki pages has got lost after the VCS switch. I'll try to renew them as soon as possible.

## 04/20/2012: 17th revision ##
This revision finally brings the support for the Libav ABI changes. It means the Libav main trunk binaries are supported again. Except the multiple ABI support there are many bugfixes and significant API changes since the last revision:
  * Top level API changes:
    * The frame decoding/encoding has been separated from the frame scaling or resampling.
    * The buffering has been completely reworked so substreams can be read independently from an interleaved stream (Note: the more time difference between two read streams the more memory will be used to buffer packets).
  * Low level API changes:
    * Interfaces has been extracted out of some wrappers so the multiple ABI support could be implemented.
    * The wrappers with multiple ABI support use factory classes instead of constructors (to ensure the proper wrapper version is created).

The top level changes also caused a big improvement of the RTSP A/V synchronization bug. The problem is still present but it's usually hard to notice and I think I'll be able to fix it.

Although the seeking is still untested and there is still no support for the TCP lower transport within the integrated RTSP server, I don't expect there will be many API-breaking changes since this revision.

## 02/28/2012: 16th revision ##
  * many tests have been added (note: some tests requires presence of the native Libav libraries)
  * ANT build script has been created
  * memcpy() UnsatisfiedLinkError on the Win32 platform has been fixed

## 02/09/2012: 12th revision ##
There is a lot of changes since the last commit:
  * audio mixing support (see the PlaybackMixer class)
  * code documentation
  * a lot of bugfixes
  * better support for the Libav API changes
  * some API changes (mostly cleanups and changes necessary for the previous point)

## 01/10/2012: 6th revision ##
The 6th revision is coming with RTSP server, SDP parsing and creation support, some API changes and many fixes (including the problem with running the jlibav on the OpenJDK and the problem with decoding of some MPEG4 video streams encoded using the DivX encoder).