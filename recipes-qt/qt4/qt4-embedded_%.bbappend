FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://003-Hack-hide-cursor-during-startup.patch"

QT_QT3SUPPORT = "-no-qt3support"
WEB = "web-webkit"
QT_PHONON = "-no-phonon"
QT_DBUS = "-no-qdbus"
QT_MULTIMEDIA = "-no-pulseaudio" 
