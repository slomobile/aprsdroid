package org.aprsdroid.app

import com.jazzido.PacketDroid.AudioBufferProcessor

class AfskInWrapper(hq : Boolean, au : AfskUploader, samplerate : Int) {
	var abp = if (!hq) new AudioBufferProcessor(au) else null
	var ad = if (hq) new AfskDemodulator(au, samplerate) else null

	def start() = if (!hq) abp.start() else ad.start()
	def close() = if (!hq) abp.stopRecording() else ad.close()
}
