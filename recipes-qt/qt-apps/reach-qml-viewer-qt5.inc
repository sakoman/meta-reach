DESCRIPTION = "Reach QML Viewer and init"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PR = "r1"

inherit qmake5
DEPENDS = "qtbase qtquick1"

SRCREV ="9b3aaae698f364588dc52431269ee078d4f6c402" 
SRC_URI = "git://github.com/jmore-reachtech/reach-qml-viewer.git;branch=qt5;protocol=git \
          file://qml-viewer.sh \
"

S = "${WORKDIR}/git"
BUILDDIR = "${WORKDIR}/build"

APP_DIR="/application/bin"

do_install() {
	install -d ${D}${APP_DIR}
	install -d ${D}${sysconfdir}/profile.d/
	install -m 0755 ${BUILDDIR}/qml-viewer ${D}${APP_DIR}
    install -m 0755 ${WORKDIR}/qml-viewer.sh ${D}${sysconfdir}/profile.d/

    # for PCAP panels add EvdevPlugin rotation
    case "${MACHINE}" in
		g2h-solo-7)
			echo 'export QT_QPA_EVDEV_TOUCHSCREEN_PARAMETERS="rotate=${QPA_EVDEV_ROTATE}"' >> ${D}${sysconfdir}/profile.d/qml-viewer.sh
        ;;
	esac
}

FILES_${PN} += "${APP_DIR} /home/root"
FILES_${PN}-dbg += "${APP_DIR}/.debug /usr/src/debug"

inherit update-rc.d
