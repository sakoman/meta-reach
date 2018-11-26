DESCRIPTION = "A qt5 image"

LICENSE = "CLOSED"

inherit core-image

IMAGE_FEATURES += "ssh-server-openssh"

TOUCH = "tslib tslib-calibrate tslib-tests"

CORE_IMAGE_EXTRA_INSTALL += " \
    ${TOUCH} \
    alsa-utils \
    liberation-fonts \
    ttf-dejavu-sans \
    ttf-dejavu-serif \
    ttf-dejavu-common \
    qtcanvas3d \
    qtdeclarative \
    qtdeclarative-tools \
    qtmultimedia \
    qtquickcontrols \
    qtquickcontrols2 \
    qtsvg \
    qtxmlpatterns \
    qtserialport \
    strace \
    packagegroup-fsl-gstreamer1.0-full \
    imx-codec-aac \
    reach-qml-app \
"

def get_layers(bb, d):
        layers = (d.getVar("BBLAYERS", d, 1) or "").split()
        layers_branch_rev = ["%-17s = \"%s:%s\"" % (os.path.basename(i), \
                base_get_metadata_git_branch(i, None).strip().strip('()'), \
                base_get_metadata_git_revision(i, None)) \
                        for i in layers]
        i = len(layers_branch_rev)-1
        p1 = layers_branch_rev[i].find("=")
        s1= layers_branch_rev[i][p1:]
        while i > 0:
                p2 = layers_branch_rev[i-1].find("=")
                s2= layers_branch_rev[i-1][p2:]
                if s1 == s2:
                        layers_branch_rev[i-1] = layers_branch_rev[i-1][0:p2]
                        i -= 1
                else:
                        i -= 1
                        p1 = layers_branch_rev[i].find("=")
                        s1= layers_branch_rev[i][p1:]

        layertext = "%s\n" % '\n'.join(layers_branch_rev)
        layertext = layertext.replace('<','')
        layertext = layertext.replace('>','')
        return layertext

write_meta_layers() {
    echo "${DISTRO} ${DISTRO_VERSION}"  > ${IMAGE_ROOTFS}/etc/reach-version
    echo "BB_VERSION        = ${BB_VERSION}" >> ${IMAGE_ROOTFS}/etc/reach-version
    echo "TARGET_ARCH       = ${TARGET_ARCH}" >> ${IMAGE_ROOTFS}/etc/reach-version
    echo "TARGET_OS         = ${TARGET_OS}" >> ${IMAGE_ROOTFS}/etc/reach-version
    echo "MACHINE           = ${MACHINE}" >> ${IMAGE_ROOTFS}/etc/reach-version
    echo "TUNE_FEATURES     = ${TUNE_FEATURES}" >> ${IMAGE_ROOTFS}/etc/reach-version
    echo "TARGET_FPU        = ${TARGET_FPU}" >> ${IMAGE_ROOTFS}/etc/reach-version
    echo "${@get_layers(bb, d)}" >> ${IMAGE_ROOTFS}/etc/reach-version
}

ROOTFS_POSTPROCESS_COMMAND_append = " \
    write_meta_layers; \
"
