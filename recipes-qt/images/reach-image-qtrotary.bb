DESCRIPTION = "A minimal qt5 image without X11"

LICENSE = "MIT"

include qt5-versions.inc

IMAGE_INSTALL_append = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    packagegroup-custom-core \
    packagegroup-custom-dev-tools-gdb \
    packagegroup-custom-dev-tools \
    firmware-imx-vpu-imx6d \
    linux-firmware \
    packagegroup-fsl-gstreamer \
    gstreamer \
    gst-plugins-base-app \
    gst-plugins-base \
    gst-plugins-good \
    gst-plugins-good-rtsp \
    gst-plugins-good-udp \
    gst-plugins-good-rtpmanager \
    gst-plugins-good-rtp \
    gst-plugins-good-video4linux2 \
    qtbase-fonts \
    qtbase-plugins \
    qtbase-tools \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-tools \
    qtdeclarative-qmlplugins \
    qtmultimedia \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    qtsvg \
    qtsvg-plugins \
    qtsensors \
    qtimageformats-plugins \
    qtsystems \
    qtsystems-tools \
    qtsystems-qmlplugins \
    qtscript \
    qt3d \
    qt3d-examples \
    qt3d-qmlplugins \
    qtwebkit \
    qtwebkit-qmlplugins \
    imx-test \    
    reach-qml-viewer-qt5 \
    reach-sio-agent \
    reach-tio-agent \
    reach-eio-agent \
    alsa-utils \
    alsa-state \
    psplash \
    reach-qml-plugins-imx \
    rotary-encoder-plugin \
    rotary-encoder-qml \
    i2c-tools \
    strace \
    wireless-tools \
    canutils \
    ifplugd-init \
    flash-installer \
"

IMAGE_INSTALL_append_g2h = "\
        u-boot-reach \
"

inherit core-image

do_rootfs[depends] += " mtd-utils-native:do_populate_sysroot "

export IMAGE_BASENAME="reach-image-qtrotary"
