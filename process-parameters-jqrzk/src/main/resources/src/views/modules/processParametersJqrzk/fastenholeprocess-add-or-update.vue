<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="公称孔径" prop="aperture">
      <el-input v-model="dataForm.aperture" placeholder="公称孔径"></el-input>
    </el-form-item>
    <el-form-item label="紧固件类型" prop="fastenType">
      <el-input v-model="dataForm.fastenType" placeholder="紧固件类型"></el-input>
    </el-form-item>
    <el-form-item label="预紧固件编号" prop="prefastenDode">
      <el-input v-model="dataForm.prefastenDode" placeholder="预紧固件编号"></el-input>
    </el-form-item>
    <el-form-item label="刀具编号" prop="toolId">
      <el-input v-model="dataForm.toolId" placeholder="刀具编号"></el-input>
    </el-form-item>
    <el-form-item label="制孔深度" prop="holeDepth">
      <el-input v-model="dataForm.holeDepth" placeholder="制孔深度"></el-input>
    </el-form-item>
    <el-form-item label="锪窝深度" prop="dimpleDepth">
      <el-input v-model="dataForm.dimpleDepth" placeholder="锪窝深度"></el-input>
    </el-form-item>
    <el-form-item label="最大孔深" prop="holeDepthMax">
      <el-input v-model="dataForm.holeDepthMax" placeholder="最大孔深"></el-input>
    </el-form-item>
    <el-form-item label="最小孔深" prop="holeDepthMin">
      <el-input v-model="dataForm.holeDepthMin" placeholder="最小孔深"></el-input>
    </el-form-item>
    <el-form-item label="制孔主轴转速" prop="shaftRotaion">
      <el-input v-model="dataForm.shaftRotaion" placeholder="制孔主轴转速"></el-input>
    </el-form-item>
    <el-form-item label="制孔进给速度" prop="shaftFeedRate">
      <el-input v-model="dataForm.shaftFeedRate" placeholder="制孔进给速度"></el-input>
    </el-form-item>
    <el-form-item label="锪窝主轴转速" prop="dimpleRotation">
      <el-input v-model="dataForm.dimpleRotation" placeholder="锪窝主轴转速"></el-input>
    </el-form-item>
    <el-form-item label="锪窝进给速度" prop="dimpleFeedRate">
      <el-input v-model="dataForm.dimpleFeedRate" placeholder="锪窝进给速度"></el-input>
    </el-form-item>
    <el-form-item label="压脚压力" prop="presserForce">
      <el-input v-model="dataForm.presserForce" placeholder="压脚压力"></el-input>
    </el-form-item>
    <el-form-item label="快进速度" prop="rapidFeedRate">
      <el-input v-model="dataForm.rapidFeedRate" placeholder="快进速度"></el-input>
    </el-form-item>
    <el-form-item label="加工起始位置" prop="startPos">
      <el-input v-model="dataForm.startPos" placeholder="加工起始位置"></el-input>
    </el-form-item>
    <el-form-item label="插钉速度" prop="insertSpeed">
      <el-input v-model="dataForm.insertSpeed" placeholder="插钉速度"></el-input>
    </el-form-item>
    <el-form-item label="拧紧扭矩" prop="torque">
      <el-input v-model="dataForm.torque" placeholder="拧紧扭矩"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          aperture: '',
          fastenType: '',
          prefastenDode: '',
          toolId: '',
          holeDepth: '',
          dimpleDepth: '',
          holeDepthMax: '',
          holeDepthMin: '',
          shaftRotaion: '',
          shaftFeedRate: '',
          dimpleRotation: '',
          dimpleFeedRate: '',
          presserForce: '',
          rapidFeedRate: '',
          startPos: '',
          insertSpeed: '',
          torque: ''
        },
        dataRule: {
          aperture: [
            { required: true, message: '公称孔径不能为空', trigger: 'blur' }
          ],
          fastenType: [
            { required: true, message: '紧固件类型不能为空', trigger: 'blur' }
          ],
          prefastenDode: [
            { required: true, message: '预紧固件编号不能为空', trigger: 'blur' }
          ],
          toolId: [
            { required: true, message: '刀具编号不能为空', trigger: 'blur' }
          ],
          holeDepth: [
            { required: true, message: '制孔深度不能为空', trigger: 'blur' }
          ],
          dimpleDepth: [
            { required: true, message: '锪窝深度不能为空', trigger: 'blur' }
          ],
          holeDepthMax: [
            { required: true, message: '最大孔深不能为空', trigger: 'blur' }
          ],
          holeDepthMin: [
            { required: true, message: '最小孔深不能为空', trigger: 'blur' }
          ],
          shaftRotaion: [
            { required: true, message: '制孔主轴转速不能为空', trigger: 'blur' }
          ],
          shaftFeedRate: [
            { required: true, message: '制孔进给速度不能为空', trigger: 'blur' }
          ],
          dimpleRotation: [
            { required: true, message: '锪窝主轴转速不能为空', trigger: 'blur' }
          ],
          dimpleFeedRate: [
            { required: true, message: '锪窝进给速度不能为空', trigger: 'blur' }
          ],
          presserForce: [
            { required: true, message: '压脚压力不能为空', trigger: 'blur' }
          ],
          rapidFeedRate: [
            { required: true, message: '快进速度不能为空', trigger: 'blur' }
          ],
          startPos: [
            { required: true, message: '加工起始位置不能为空', trigger: 'blur' }
          ],
          insertSpeed: [
            { required: true, message: '插钉速度不能为空', trigger: 'blur' }
          ],
          torque: [
            { required: true, message: '拧紧扭矩不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/processParametersJqrzk/fastenholeprocess/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aperture = data.fastenHoleProcess.aperture
                this.dataForm.fastenType = data.fastenHoleProcess.fastenType
                this.dataForm.prefastenDode = data.fastenHoleProcess.prefastenDode
                this.dataForm.toolId = data.fastenHoleProcess.toolId
                this.dataForm.holeDepth = data.fastenHoleProcess.holeDepth
                this.dataForm.dimpleDepth = data.fastenHoleProcess.dimpleDepth
                this.dataForm.holeDepthMax = data.fastenHoleProcess.holeDepthMax
                this.dataForm.holeDepthMin = data.fastenHoleProcess.holeDepthMin
                this.dataForm.shaftRotaion = data.fastenHoleProcess.shaftRotaion
                this.dataForm.shaftFeedRate = data.fastenHoleProcess.shaftFeedRate
                this.dataForm.dimpleRotation = data.fastenHoleProcess.dimpleRotation
                this.dataForm.dimpleFeedRate = data.fastenHoleProcess.dimpleFeedRate
                this.dataForm.presserForce = data.fastenHoleProcess.presserForce
                this.dataForm.rapidFeedRate = data.fastenHoleProcess.rapidFeedRate
                this.dataForm.startPos = data.fastenHoleProcess.startPos
                this.dataForm.insertSpeed = data.fastenHoleProcess.insertSpeed
                this.dataForm.torque = data.fastenHoleProcess.torque
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/processParametersJqrzk/fastenholeprocess/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aperture': this.dataForm.aperture,
                'fastenType': this.dataForm.fastenType,
                'prefastenDode': this.dataForm.prefastenDode,
                'toolId': this.dataForm.toolId,
                'holeDepth': this.dataForm.holeDepth,
                'dimpleDepth': this.dataForm.dimpleDepth,
                'holeDepthMax': this.dataForm.holeDepthMax,
                'holeDepthMin': this.dataForm.holeDepthMin,
                'shaftRotaion': this.dataForm.shaftRotaion,
                'shaftFeedRate': this.dataForm.shaftFeedRate,
                'dimpleRotation': this.dataForm.dimpleRotation,
                'dimpleFeedRate': this.dataForm.dimpleFeedRate,
                'presserForce': this.dataForm.presserForce,
                'rapidFeedRate': this.dataForm.rapidFeedRate,
                'startPos': this.dataForm.startPos,
                'insertSpeed': this.dataForm.insertSpeed,
                'torque': this.dataForm.torque
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
