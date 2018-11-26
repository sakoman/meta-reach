require conf/distro/poky.conf

DISTRO = "reach-base"
DISTRO_NAME = "Reach Technology Distro Base"
DISTRO_VERSION = "2.4"

SDKPATH = "/opt/reach/sdk/${SDK_VERSION}"

SDK_VENDOR = "-reachsdk"

MAINTAINER = "Reach Technology <techsupport@reachtech.com>"

TARGET_VENDOR = "-reach"

DISTROOVERRIDES = "reach"

# This function changes the default tune for machines which are based on armv7a
# to use common tune value
def arm_tune_handler(d):
    features = d.getVar('TUNE_FEATURES', True).split()
    if 'armv7a' in features or 'armv7ve' in features:
        tune = 'armv7athf'
        if 'bigendian' in features:
            tune += 'b'
        if 'vfpv3' in features:
            tune += '-vfpv3'
        if 'vfpv3d16' in features:
            tune += '-vfpv3d16'
        if 'neon' in features:
            tune += '-neon'
        if 'vfpv4' in features:
            tune += '-vfpv4'
    else:
        tune = d.getVar('DEFAULTTUNE', True)
    return tune

DEFAULTTUNE_reach := "${@arm_tune_handler(d)}"

DISTRO_ARM_INSTRUCTION ?= "thumb"
DISTRO_ARM_INSTRUCTION_armv5 ?= "arm"
ARM_INSTRUCTION_SET_reach ??= "${DISTRO_ARM_INSTRUCTION}"

# Log information on images and packages
INHERIT += "buildhistory"
BUILDHISTORY_COMMIT = "1"