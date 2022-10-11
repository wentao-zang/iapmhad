<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="主轴转速" prop="rotvel">
      <el-input v-model="dataForm.rotvel" placeholder="主轴转速"></el-input>
    </el-form-item>
    <el-form-item label="进给速度" prop="vel">
      <el-input v-model="dataForm.vel" placeholder="进给速度"></el-input>
    </el-form-item>
    <el-form-item label="主轴温度" prop="temp">
      <el-input v-model="dataForm.temp" placeholder="主轴温度"></el-input>
    </el-form-item>
    <el-form-item label="主轴电流" prop="current">
      <el-input v-model="dataForm.current" placeholder="主轴电流"></el-input>
    </el-form-item>
    <el-form-item label="主轴转矩" prop="torque">
      <el-input v-model="dataForm.torque" placeholder="主轴转矩"></el-input>
    </el-form-item>
    <el-form-item label="主轴功率" prop="power">
      <el-input v-model="dataForm.power" placeholder="主轴功率"></el-input>
    </el-form-item>
    <el-form-item label="主轴位置x" prop="posx">
      <el-input v-model="dataForm.posx" placeholder="主轴位置x"></el-input>
    </el-form-item>
    <el-form-item label="主轴位置y" prop="posy">
      <el-input v-model="dataForm.posy" placeholder="主轴位置y"></el-input>
    </el-form-item>
    <el-form-item label="主轴位置z" prop="posz">
      <el-input v-model="dataForm.posz" placeholder="主轴位置z"></el-input>
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
          rotvel: '',
          vel: '',
          temp: '',
          current: '',
          torque: '',
          power: '',
          posx: '',
          posy: '',
          posz: ''
        },
        dataRule: {
          rotvel: [
            { required: true, message: '主轴转速不能为空', trigger: 'blur' }
          ],
          vel: [
            { required: true, message: '进给速度不能为空', trigger: 'blur' }
          ],
          temp: [
            { required: true, message: '主轴温度不能为空', trigger: 'blur' }
          ],
          current: [
            { required: true, message: '主轴电流不能为空', trigger: 'blur' }
          ],
          torque: [
            { required: true, message: '主轴转矩不能为空', trigger: 'blur' }
          ],
          power: [
            { required: true, message: '主轴功率不能为空', trigger: 'blur' }
          ],
          posx: [
            { required: true, message: '主轴位置x不能为空', trigger: 'blur' }
          ],
          posy: [
            { required: true, message: '主轴位置y不能为空', trigger: 'blur' }
          ],
          posz: [
            { required: true, message: '主轴位置z不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/yhmachinedrilling/spinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.rotvel = data.spinfo.rotvel
                this.dataForm.vel = data.spinfo.vel
                this.dataForm.temp = data.spinfo.temp
                this.dataForm.current = data.spinfo.current
                this.dataForm.torque = data.spinfo.torque
                this.dataForm.power = data.spinfo.power
                this.dataForm.posx = data.spinfo.posx
                this.dataForm.posy = data.spinfo.posy
                this.dataForm.posz = data.spinfo.posz
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
              url: this.$http.adornUrl(`/yhmachinedrilling/spinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'rotvel': this.dataForm.rotvel,
                'vel': this.dataForm.vel,
                'temp': this.dataForm.temp,
                'current': this.dataForm.current,
                'torque': this.dataForm.torque,
                'power': this.dataForm.power,
                'posx': this.dataForm.posx,
                'posy': this.dataForm.posy,
                'posz': this.dataForm.posz
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
