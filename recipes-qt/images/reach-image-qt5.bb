##
# See cinematicexperience_1.0.bb for video info
# Use this video setting for uboot:
# setenv mmcargs setenv bootargs console=${console},${baudrate} root=${mmcroot} fbmem=24M video=mxcfb0:dev=ldb,LDB-WVGA,if=RGB666,bpp=32
##
DESCRIPTION = "A very basic qt5 image with a demo"

IMAGE_FEATURES += "splash x11-base"

LICENSE = "MIT"

IMAGE_OVERHEAD_FACTOR = "2.0"

IMAGE_INSTALL_append = " \
	packagegroup-custom-dev-tools \
	packagegroup-custom-dev-tools-gdb \
	packagegroup-custom-core \
"

inherit core-image

IMAGE_INSTALL += " \
    util-linux \
    imx-test \ 
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
    qtwebkit \
    qtwebkit-qmlplugins \
    qt3d \
    qt3d-qmlplugins \
    qt3d-tools \
    reach-qt5-demo \
    "


export IMAGE_BASENAME = "reach-image-qt5"
